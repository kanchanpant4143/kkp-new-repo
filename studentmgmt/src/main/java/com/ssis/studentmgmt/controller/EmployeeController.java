package com.ssis.studentmgmt.controller;

import com.ssis.studentmgmt.common.Clazz;
import com.ssis.studentmgmt.common.SchoolConverter;
import com.ssis.studentmgmt.dto.EmployeeDto;
import com.ssis.studentmgmt.dto.Message;
import com.ssis.studentmgmt.dto.StudentDto;
import com.ssis.studentmgmt.models.Employee;
import com.ssis.studentmgmt.models.Student;
import com.ssis.studentmgmt.service.EmployeeService;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/employee"})
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    ModelMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String enterEmployee(Model m) {
        EmployeeDto emp = new EmployeeDto();
        m.addAttribute("employee", emp);
        return "employee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") EmployeeDto employee, Model m, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            Employee saved = employeeService.saveEmployee(dtoToModel(employee));
            System.out.println("Employee saved successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Employee saved successfully!!","success"));
            }
        } catch (Exception e){
            logger.error("Something went wrong!! try again.",e);
            session.setAttribute("message", new Message("Something went wrong!! try again.","danger"));
        }
        return "redirect:/employee/add";
    }

    @GetMapping(value = {"/list"})
    public String getAllEmployees(Model m) {
        List<EmployeeDto> employees = new ArrayList<>();
        List<Employee> models = employeeService.getAllEmployees();
        if(!CollectionUtils.isEmpty(models)) {
            employees = modelsToDtoList(models);
        }
        m.addAttribute("employees", employees);
        //m.addAttribute("classes", classes);
        return "employeeList";
    }

    @GetMapping(value = {"/delete/{id}"})
    public String deleteEmployee(@PathVariable("id") Integer id, Model m) {
        employeeService.deleteById(id);
        List<EmployeeDto> employees = new ArrayList<>();
        List<Employee> models = employeeService.getAllEmployees();
        if(!CollectionUtils.isEmpty(models)) {
            employees = modelsToDtoList(models);
        }
        m.addAttribute("employees", employees);
        //m.addAttribute("classes", classes);
        return "employeeList";
    }

    @GetMapping(value = {"/select/{eid}"})
    public String getEmpById(@PathVariable("eid") Integer eid, Model m) {
        EmployeeDto employee = new EmployeeDto();
        Optional<Employee> model = employeeService.getEmpById(eid);
        if(model.isPresent()) {
            employee = modeloToDto(model.get());
        }
        m.addAttribute("employee", employee);
        return "editEmployee";
    }

    @PostMapping(value = "/update")
    public String updateEmp(@ModelAttribute("student") EmployeeDto employee, Model m,  HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            Employee saved = employeeService.saveEmployee(dtoToModel(employee));
            System.out.println("Employee updated successfully");
            if (saved != null) {
                session.setAttribute("message", new Message("Employee updated successfully!!","success"));
            }
        } catch (Exception e){
            logger.error("Something went wrong!! try again.",e);
            session.setAttribute("message", new Message("Something went wrong!! try again.","danger"));
        }
        return "redirect:/employee/list";
    }

    public Employee dtoToModel(EmployeeDto dto) {
        Employee model = mapper.map(dto, Employee.class);
        return model;
    }

    public EmployeeDto modeloToDto(Employee model) {
        EmployeeDto dto = mapper.map(model, EmployeeDto.class);
        return dto;
    }

    private List<EmployeeDto> modelsToDtoList(List<Employee> models) {
        List<EmployeeDto> employees = models.stream().map(m -> modeloToDto(m)).collect(Collectors.toList());
        return employees;
    }

}
