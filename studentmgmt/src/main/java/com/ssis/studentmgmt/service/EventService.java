package com.ssis.studentmgmt.service;

import com.ssis.studentmgmt.models.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Event saveEvent(Event event);

    Optional<Event> getEventById(Integer id);

    List<Event> getAllEvents();

    void deleteEvent(Integer id);

}
