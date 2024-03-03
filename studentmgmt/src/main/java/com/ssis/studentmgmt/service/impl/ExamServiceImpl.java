package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.Exam;
import com.ssis.studentmgmt.repositories.ExamRepository;
import com.ssis.studentmgmt.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("examService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepository examRepo;

    @Override
    public Exam saveExam(Exam exam) {
        return examRepo.save(exam);
    }

    @Override
    public Exam editExam(Exam exam) {
        return examRepo.save(exam);
    }

    @Override
    public Optional<Exam> findById(Integer id) {
        return examRepo.findById(id);
    }

    @Override
    public List<Exam> findAll() {
        return examRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        examRepo.deleteById(id);
    }
}
