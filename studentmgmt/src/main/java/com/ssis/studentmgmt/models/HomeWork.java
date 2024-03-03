package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "HOMEWORK_TBL")
public class HomeWork extends BaseEntity {

    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "BY_TEACHER")
    private String byTeacher;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ASSIGNED_DATE")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;
    @Column(name = "COMPLETION_DATE")
    @Temporal(TemporalType.DATE)
    private Date completionDate;

}
