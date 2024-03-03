package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.UserLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userLinkRepo")
public interface UserLinkRepository extends JpaRepository<UserLink, Integer> {

    @Query("select u from UserLink u where u.role =:role or u.role = 'GENERAL'")
    public List<UserLink> getLinksByRole(@Param("role") String role);

}
