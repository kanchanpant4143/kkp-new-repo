package com.ssis.studentmgmt.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto extends BaseDto implements Serializable {

    private String eventHeading;
    private String briefDescription;
    private String description;
    private String eventDateTime;

}


