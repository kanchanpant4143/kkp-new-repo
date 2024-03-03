package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.Student;
import com.ssis.studentmgmt.repositories.StudentRepository;
import com.ssis.studentmgmt.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceImplTest {

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @Mock
    StudentRepository repo;

    @Test
    public void getStudentsByIdTest() {
        when(repo.findById(1)).thenReturn(createStudentStub());
        Optional<Student> tested = studentServiceImpl.getStudentsById(1);
        assertEquals(tested.get().getFirstName(),"KANCHAN");
    }

    private Optional<Student> createStudentStub() {
        Student student = Student.builder().firstName("KANCHAN").middleName("KUMAR").lastName("PANT").dob("2023-02-20").build();
        return Optional.of(student);
    }


}
