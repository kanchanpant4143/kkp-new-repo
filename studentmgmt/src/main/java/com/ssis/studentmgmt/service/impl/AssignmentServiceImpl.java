package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.Assignment;
import com.ssis.studentmgmt.repositories.AssignmentRepository;
import com.ssis.studentmgmt.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepo;

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }

    @Override
    public Assignment editAssignment(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }

    @Override
    public Optional<Assignment> getAssignmentById(Integer id) {
        return assignmentRepo.findById(id);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepo.findAll();
    }

    @Override
    public void deleteAssignment(Integer id) {
        assignmentRepo.deleteById(id);
    }

    @Override
    public List<Assignment> getAssignmentsByDate(String dated) {
        return assignmentRepo.getAssignmentsByDate(dated);
    }
}
