package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.dto.UserDto;
import com.ssis.studentmgmt.models.User;
import com.ssis.studentmgmt.repositories.UserRepository;
import com.ssis.studentmgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public Optional<User> getUserByName(String username) {
        return userRepo.getUserByName(username);
    }
}
