package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentsByClass(String clazz, String session);

    Optional<Student> getStudentsById(Integer sid);

    void deleteById(Integer id);
}
