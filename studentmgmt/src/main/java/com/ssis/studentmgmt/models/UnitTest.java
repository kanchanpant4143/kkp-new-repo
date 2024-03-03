package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "UNITTEST_TBL")
public class UnitTest extends BaseEntity {

    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "TEST_DATE")
    @Temporal(TemporalType.DATE)
    private Date testDate;
    @Column(name = "DESCRIPTION")
    private String description;

}
