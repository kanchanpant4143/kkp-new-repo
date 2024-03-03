package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.Clazz;
import com.ssis.studentmgmt.common.EnumList;
import com.ssis.studentmgmt.dto.EmployeeDto;
import com.ssis.studentmgmt.dto.Message;
import com.ssis.studentmgmt.dto.StudentDto;
import com.ssis.studentmgmt.models.Employee;
import com.ssis.studentmgmt.models.Student;
import com.ssis.studentmgmt.service.EmployeeService;
import com.ssis.studentmgmt.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
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
@RequestMapping(value = {"/student"})
public class StudentController {

    @Autowired
    EnumList enums;
    @Autowired
    StudentService studentService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(Model m) {
        StudentDto student = new StudentDto();
        m.addAttribute("student", student);
        m.addAttribute("classes", enums.getClasses());
        return "student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") StudentDto student, Model m, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            Student saved = studentService.saveStudent(dtoToModel(student));
            System.out.println("Student saved successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Student saved successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/student/add";
    }

    @GetMapping(value = {"/list"})
    public String getAllStudents(Model m) {
        List<StudentDto> students = new ArrayList<>();
        List<Student> models = studentService.getAllStudents();
        /*if (models.size() < 5) {
            throw new NullPointerException();
        }*/
        if (!CollectionUtils.isEmpty(models)) {
            students = modelsToDtoList(models);
        }
        m.addAttribute("students", students);
        //m.addAttribute("classes", classes);
        return "studentList";
    }

    @GetMapping(value = {"/delete/{id}"})
    public String deleteStudent(@PathVariable("id") Integer id, Model m) {
        studentService.deleteById(id);
        List<StudentDto> students = new ArrayList<>();
        List<Student> models = studentService.getAllStudents();
        if (!CollectionUtils.isEmpty(models)) {
            students = modelsToDtoList(models);
        }
        m.addAttribute("students", students);
        //m.addAttribute("classes", classes);
        return "studentList";
    }

    @GetMapping(value = {"/list/{clazz}"})
    public String getStudentByClass(@ModelAttribute("clazz") String clazz, @ModelAttribute("session") String session, Model m) {
        //List<Clazz> classes = Arrays.stream(schoolEnums.getClasses()).collect(Collectors.toList());
        List<StudentDto> students = new ArrayList<>();
        List<Student> models = studentService.getStudentsByClass(clazz, session);
        m.addAttribute("students", students);
        //m.addAttribute("classes", classes);
        return "student";
    }

    @GetMapping(value = {"/select/{sid}"})
    public String getStudentById(@PathVariable("sid") Integer sid, Model m) {
        StudentDto student = new StudentDto();
        Optional<Student> model = studentService.getStudentsById(sid);
        if (model.isPresent()) {
            student = modeloToDto(model);
        }
        m.addAttribute("student", student);
        m.addAttribute("classes", enums.getClasses());
        return "editStudent";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@ModelAttribute("student") StudentDto student, Model m, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            Student saved = studentService.saveStudent(dtoToModel(student));
            System.out.println("Student updated successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Student updated successfully!!", "success"));
            }
        } catch (Exception e) {
            logger.error("Something went wrong!! try again.", e);
            session.setAttribute("message", new Message("Something went wrong!! try again.", "danger"));
        }
        return "redirect:/student/list";
    }

    public Student dtoToModel(StudentDto dto) {
        Student model = mapper.map(dto, Student.class);
        return model;
    }

    public StudentDto modeloToDto(Optional<Student> model) {
        StudentDto dto = mapper.map(model, StudentDto.class);
        return dto;
    }

    private List<StudentDto> modelsToDtoList(List<Student> models) {
        List<StudentDto> students = models.stream().map(m -> modeloToDto(Optional.ofNullable(m))).collect(Collectors.toList());
        return students;
    }

}
