package com.ssis.studentmgmt.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLinkDto extends BaseDto {

    private String link;
    private String role;
    private String label;

}

