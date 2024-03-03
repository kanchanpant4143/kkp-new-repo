package com.ssis.studentmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto extends BaseDto implements Serializable {

    private String session;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private String clazz;
    private String section;
    private String fatherName;
    private String motherName;

}
