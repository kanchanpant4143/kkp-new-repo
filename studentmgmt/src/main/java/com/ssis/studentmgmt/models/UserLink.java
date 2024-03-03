package com.ssis.studentmgmt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_LINK_TBL")
public class UserLink extends BaseEntity {

    @Column(name = "link")
    private String link;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "LABEL")
    private String label;

}
