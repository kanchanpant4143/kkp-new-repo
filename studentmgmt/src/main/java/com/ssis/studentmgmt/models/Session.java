package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SESSION_MASTER")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SESSION_ID")
    private Integer sessionId;
    @Column(name = "SESSION")
    private String session;

}
