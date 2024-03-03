package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.EnumList;
import com.ssis.studentmgmt.dto.EventDto;
import com.ssis.studentmgmt.dto.Message;
import com.ssis.studentmgmt.dto.StudentDto;
import com.ssis.studentmgmt.models.Event;
import com.ssis.studentmgmt.models.Student;
import com.ssis.studentmgmt.service.EventService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/event"})
public class EventController {

    @Autowired
    EnumList enums;
    @Autowired
    EventService eventService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @GetMapping(value = {"/add"})
    public String addEvent(Model m) {
        //m.addAttribute("testData", "Testing");
        EventDto event = new EventDto();
        m.addAttribute("event", event);
        return "event";
    }

    @PostMapping(value = "/save")
    public String saveEvent(@ModelAttribute("event") EventDto event, Model m, HttpSession session) {
        //m.addAttribute("testData", "Testing");
        try {
            Event saved = eventService.saveEvent(dtoToModel(event));
            System.out.println("Event saved successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Event saved successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "event";
    }

    @GetMapping(value = "/list")
    public String getEventsList(Model m) {
        //m.addAttribute("testData", "Testing");
        List<EventDto> events = new ArrayList<>();
        List<Event> models = eventService.getAllEvents();
        System.out.println("models: " + models);
        if (!CollectionUtils.isEmpty(models)) {
            events = modelsToDtoList(models);
        }
        System.out.println("events: " + events);
        m.addAttribute("events", events);
        return "eventList";
    }

    @GetMapping(value = "/select/{id}")
    public String getEventById(@PathVariable("id") Integer id, Model m) {
        EventDto event = new EventDto();
        Optional<Event> model = eventService.getEventById(id);
        if (model.isPresent()) {
            event = modeloToDto(model);
        }
        m.addAttribute("event", event);
        return "editEvent";
    }

    @PostMapping(value = {"/update"})
    public String updateEvent(@ModelAttribute("event") EventDto event, Model m, HttpSession session) {
        try {
            Event saved = eventService.saveEvent(dtoToModel(event));
            System.out.println("Event updated successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Event updated successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/event/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEvent(@PathVariable("id") Integer id, Model m) {
        eventService.deleteEvent(id);
        return "redirect:/event/list";
    }

    public Event dtoToModel(EventDto dto) {
        Event model = mapper.map(dto, Event.class);
        return model;
    }

    public EventDto modeloToDto(Optional<Event> model) {
        EventDto dto = mapper.map(model, EventDto.class);
        return dto;
    }

    private List<EventDto> modelsToDtoList(List<Event> models) {
        List<EventDto> events = models.stream().map(m -> modeloToDto(Optional.ofNullable(m))).collect(Collectors.toList());
        return events;
    }

}
