package com.ssis.studentmgmt.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto implements Serializable {

    private String username;
    private String password;
    private String role;

}
