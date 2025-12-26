package com.example.demo.service;

import com.example.demo.entity.Event;
import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    List<Event> getActiveEvents();
    List<Event> getAll();
    void deactivateEvent(Long id);
    Event getById(Long id);
    Event getEventById(Long id);
}
