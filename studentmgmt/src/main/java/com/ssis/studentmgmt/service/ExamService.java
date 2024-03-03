package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.models.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamService {

    Exam saveExam(Exam exam);

    Exam editExam(Exam exam);

    Optional<Exam> findById(Integer id);

    List<Exam> findAll();

    void deleteById(Integer id);

}
