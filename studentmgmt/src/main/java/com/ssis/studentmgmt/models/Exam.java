package com.ssis.studentmgmt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EXAM_TBL")
public class Exam extends BaseEntity {

    @Column(name = "EXAM_TYPE")
    private String examType;
    @Column(name = "CLAZZ")
    private String clazz;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "EXAM_DATE")
    private String examDate;
    @Column(name = "SYLLABUS")
    private String syllabus;

}
