package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.EnumList;
import com.ssis.studentmgmt.dto.AssignmentDto;
import com.ssis.studentmgmt.dto.Message;
import com.ssis.studentmgmt.models.Assignment;
import com.ssis.studentmgmt.service.AssignmentService;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/assignment")
public class AssignmentController {

    @Autowired
    EnumList enums;
    @Autowired
    AssignmentService assignmentService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(AssignmentController.class);

    @GetMapping(value = {"/add"})
    public String addAssignment(Model m) {
        //m.addAttribute("testData", "Testing");
        AssignmentDto assignment = new AssignmentDto();
        m.addAttribute("assignment", assignment);
        m.addAttribute("classes", enums.getClasses());
        return "assignment";
    }

    @PostMapping(value = "/save")
    public String saveAssignemnt(@ModelAttribute("assignment") AssignmentDto assignment, Model m, HttpSession session) {
        //m.addAttribute("testData", "Testing");
        try {
            Assignment saved = assignmentService.saveAssignment(dtoToModel(assignment));
            System.out.println("Assignment saved successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Assignment saved successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/assignment/add";
    }

    @GetMapping(value = "/list")
    public String getAssignmentsList(Model m) {
        //m.addAttribute("testData", "Testing");
        List<AssignmentDto> assignments = new ArrayList<>();
        List<Assignment> models = assignmentService.getAllAssignments();
        System.out.println("models: " + models);
        if (!CollectionUtils.isEmpty(models)) {
            assignments = modelsToDtoList(models);
        }
        System.out.println("assignments: " + assignments);
        m.addAttribute("assignments", assignments);
        return "assignmentList";
    }

    @GetMapping(value = "/select/{id}")
    public String getAssignmentById(@PathVariable("id") Integer id, Model m) {
        AssignmentDto assignment = new AssignmentDto();
        Optional<Assignment> model = assignmentService.getAssignmentById(id);
        if (model.isPresent()) {
            assignment = modelToDto(model);
        }
        m.addAttribute("assignment", assignment);
        return "editAssignment";
    }

    @PostMapping(value = {"/update"})
    public String updateAssignment(@ModelAttribute("assignment") AssignmentDto assignment, Model m, HttpSession session) {
        try {
            Assignment saved = assignmentService.saveAssignment(dtoToModel(assignment));
            System.out.println("Assignment updated successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Assignment updated successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/assignment/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteAssignment(@PathVariable("id") Integer id, Model m) {
        assignmentService.deleteAssignment(id);
        return "redirect:/assignment/list";
    }

    public Assignment dtoToModel(AssignmentDto dto) {
        Assignment model = mapper.map(dto, Assignment.class);
        return model;
    }

    public AssignmentDto modelToDto(Optional<Assignment> model) {
        AssignmentDto dto = mapper.map(model, AssignmentDto.class);
        return dto;
    }

    private List<AssignmentDto> modelsToDtoList(List<Assignment> models) {
        List<AssignmentDto> assignments = models.stream().map(m -> modelToDto(Optional.ofNullable(m))).collect(Collectors.toList());
        return assignments;
    }

}
