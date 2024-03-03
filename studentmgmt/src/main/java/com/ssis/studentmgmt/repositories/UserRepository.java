package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username =:username")
    public Optional<User> getUserByName(@Param("username") String username);

}
