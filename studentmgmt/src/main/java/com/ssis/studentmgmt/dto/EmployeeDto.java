package com.ssis.studentmgmt.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto extends BaseDto implements Serializable {

    private String empName;
    private String dob;
    private String designation;
    private String mobileNo;
    private String address;
    private String aadharNo;
    private String contactName;
    private String contactNo;

}
