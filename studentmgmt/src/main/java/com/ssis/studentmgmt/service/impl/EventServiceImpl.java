package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.Event;
import com.ssis.studentmgmt.repositories.EventRepository;
import com.ssis.studentmgmt.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("eventService")
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepo;

    @Override
    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Optional<Event> getEventById(Integer id) {
        return eventRepo.findById(id);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepo.deleteById(id);
    }
}
