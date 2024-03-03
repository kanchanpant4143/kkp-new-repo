package com.ssis.studentmgmt.service.impl;

import com.ssis.studentmgmt.models.UserLink;
import com.ssis.studentmgmt.repositories.UserLinkRepository;
import com.ssis.studentmgmt.service.UserLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userLinkService")
public class UserLinkServiceImpl implements UserLinkService {

    @Autowired
    UserLinkRepository userLinkRepo;

    @Override
    public List<UserLink> getLinksByRole(String userRole) {
        return userLinkRepo.getLinksByRole(userRole);
    }
}
