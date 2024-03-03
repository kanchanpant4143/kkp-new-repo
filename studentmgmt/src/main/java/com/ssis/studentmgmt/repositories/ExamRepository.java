package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("examRepo")
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
