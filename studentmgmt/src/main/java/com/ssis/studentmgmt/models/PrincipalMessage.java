package com.ssis.studentmgmt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PRINCIPAL_MSG_TBL")
public class PrincipalMessage extends BaseEntity {

    @Column(name = "MESSAGE")
    private String message;

}
