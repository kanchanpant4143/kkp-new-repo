package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepo")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
