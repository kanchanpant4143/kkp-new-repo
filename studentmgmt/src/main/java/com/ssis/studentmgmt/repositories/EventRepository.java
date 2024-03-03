package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepo")
public interface EventRepository extends JpaRepository<Event, Integer> {
}
