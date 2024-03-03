package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.Employee;
import com.ssis.studentmgmt.repositories.EmployeeRepository;
import com.ssis.studentmgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    @Override
    public Employee saveEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        empRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> getEmpById(Integer eid) {
        return empRepo.findById(eid);
    }

}
