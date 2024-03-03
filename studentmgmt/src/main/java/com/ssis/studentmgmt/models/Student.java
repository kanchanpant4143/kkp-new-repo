package com.ssis.studentmgmt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT_TBL")
public class Student extends BaseEntity {

    @Column(name = "SESSION")
    private String session;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "CLAZZ")
    private String clazz;
    @Column(name = "SECTION")
    private String section;
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Column(name = "MOTHER_NAME")
    private String motherName;

}
