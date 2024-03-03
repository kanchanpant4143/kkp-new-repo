package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.dto.UserDto;
import com.ssis.studentmgmt.models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByName(String user);
}
