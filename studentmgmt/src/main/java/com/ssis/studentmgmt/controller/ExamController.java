package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.Clazz;
import com.ssis.studentmgmt.common.EnumList;
import com.ssis.studentmgmt.common.ExamType;
import com.ssis.studentmgmt.dto.AssignmentDto;
import com.ssis.studentmgmt.dto.ExamDto;
import com.ssis.studentmgmt.dto.Message;
import com.ssis.studentmgmt.models.Assignment;
import com.ssis.studentmgmt.models.Exam;
import com.ssis.studentmgmt.service.AssignmentService;
import com.ssis.studentmgmt.service.ExamService;
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
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    EnumList enums;
    @Autowired
    ExamService examService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(ExamController.class);

    @GetMapping(value = {"/add"})
    public String addExam(Model m) {
        //m.addAttribute("testData", "Testing");
        ExamDto examDto = new ExamDto();
        m.addAttribute("exam", examDto);
        m.addAttribute("exams", enums.getExams());
        m.addAttribute("classes", enums.getClasses());
        return "exam";
    }

    @PostMapping(value = "/save")
    public String saveExam(@ModelAttribute("exam") ExamDto exam, Model m, HttpSession session) {
        //m.addAttribute("testData", "Testing");
        try {
            Exam saved = examService.saveExam(dtoToModel(exam));
            System.out.println("Exam saved successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Exam saved successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/exam/add";
    }

    @GetMapping(value = "/list")
    public String getExamsList(Model m) {
        //m.addAttribute("testData", "Testing");
        List<ExamDto> exams = new ArrayList<>();
        List<Exam> models = examService.findAll();
        System.out.println("models: " + models);
        if (!CollectionUtils.isEmpty(models)) {
            exams = modelsToDtoList(models);
        }
        logger.info("exams: " + exams);
        m.addAttribute("exams", exams);
        return "examList";
    }

    @GetMapping(value = "/select/{id}")
    public String getExamById(@PathVariable("id") Integer id, Model m) {
        ExamDto exam = new ExamDto();
        Optional<Exam> model = examService.findById(id);
        if (model.isPresent()) {
            exam = modelToDto(model);
        }
        m.addAttribute("exam", exam);
        return "editExam";
    }

    @PostMapping(value = {"/update"})
    public String updateExam(@ModelAttribute("exam") ExamDto exam, Model m, HttpSession session) {
        try {
            Exam saved = examService.saveExam(dtoToModel(exam));
            logger.info("Exam updated successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Exam updated successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/exam/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteExam(@PathVariable("id") Integer id, Model m) {
        examService.deleteById(id);
        return "redirect:/exam/list";
    }

    public Exam dtoToModel(ExamDto dto) {
        Exam model = mapper.map(dto, Exam.class);
        return model;
    }

    public ExamDto modelToDto(Optional<Exam> model) {
        ExamDto dto = mapper.map(model, ExamDto.class);
        return dto;
    }

    private List<ExamDto> modelsToDtoList(List<Exam> models) {
        List<ExamDto> exams = models.stream().map(m -> modelToDto(Optional.ofNullable(m))).collect(Collectors.toList());
        return exams;
    }

}
