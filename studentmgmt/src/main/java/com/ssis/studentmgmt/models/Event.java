package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "EVENT_TBL")
public class Event extends BaseEntity {

    @Column(name = "EVENT_HEADING")
    private String eventHeading;
    @Column(name = "BRIEF_DESC")
    private String briefDescription;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "EVENT_DATE_TIME")
    private String eventDateTime;

}
