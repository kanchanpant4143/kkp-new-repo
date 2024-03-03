package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMP_TBL")
public class Employee extends BaseEntity {

    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "AADHAR_NO")
    private String aadharNo;
    @Column(name = "EMERGENCY_CONTACT_NAME")
    private String contactName;
    @Column(name = "EMERGENCY_CONTACT_NO")
    private String contactNo;

}
