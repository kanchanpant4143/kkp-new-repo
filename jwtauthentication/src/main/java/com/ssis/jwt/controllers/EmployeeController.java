package com.ssis.jwt.controllers;

import com.ssis.jwt.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(UUID.randomUUID().toString(), "Kanchan", 40);
        Employee emp2 = new Employee(UUID.randomUUID().toString(), "Bhawana", 36);
        Employee emp3 = new Employee(UUID.randomUUID().toString(), "Neha", 35);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        return ResponseEntity.ok(list);
    }

}
