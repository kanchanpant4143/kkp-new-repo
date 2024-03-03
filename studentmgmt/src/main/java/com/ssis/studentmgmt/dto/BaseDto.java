package com.ssis.studentmgmt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class BaseDto {

    private Integer id;
    private String createdBy;
    private Date createdDate;

}
