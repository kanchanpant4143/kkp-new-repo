package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.Student;
import com.ssis.studentmgmt.repositories.StudentRepository;
import com.ssis.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public List<Student> getStudentsByClass(String clazz, String session) {
        return studentRepo.findByClass(clazz, session);
    }

    @Override
    public Optional<Student> getStudentsById(Integer sid) {
        return studentRepo.findById(sid);
    }

    @Override
    public void deleteById(Integer id) {
       studentRepo.deleteById(id);
    }

}
