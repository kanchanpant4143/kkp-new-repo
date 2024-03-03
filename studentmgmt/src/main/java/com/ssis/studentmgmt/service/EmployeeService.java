package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee emp);

    List<Employee> getAllEmployees();

    void deleteById(Integer id);

    Optional<Employee> getEmpById(Integer eid);
}
