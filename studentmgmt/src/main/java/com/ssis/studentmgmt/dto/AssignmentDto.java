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
public class AssignmentDto extends BaseDto implements Serializable {

    private String clazz;
    private String section;
    private String subject;
    private String teacher;
    private String description;
    private String assignedDate;
    private String completionDate;

}
