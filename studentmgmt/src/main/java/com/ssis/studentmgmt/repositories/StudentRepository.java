package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentRepo")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.clazz = :clazz and s.session = :session")
    List<Student> findByClass(@Param("clazz") String clazz, @Param("session") String session);
}
