package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.models.UserLink;

import java.util.List;

public interface UserLinkService {

    List<UserLink> getLinksByRole(String userRole);

}
