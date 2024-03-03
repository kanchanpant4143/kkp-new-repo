package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.models.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {

    Assignment saveAssignment(Assignment assignment);

    Assignment editAssignment(Assignment assignment);

    Optional<Assignment> getAssignmentById(Integer id);

    List<Assignment> getAllAssignments();

    void deleteAssignment(Integer id);

    List<Assignment> getAssignmentsByDate(String dated);

}
