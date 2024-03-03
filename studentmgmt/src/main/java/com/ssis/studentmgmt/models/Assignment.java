package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ASSIGNMENT_TBL")
public class Assignment extends BaseEntity {

    @Column(name = "CLAZZ")
    private String clazz;
    @Column(name = "SECTION")
    private String section;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "BY_TEACHER")
    private String teacher;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ASSIGNED_DATE")
    private String assignedDate;
    @Column(name = "COMPLETION_DATE")
    private String completionDate;

}
