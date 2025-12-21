package com.example.demo.service;

import com.example.demo.entity.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event getEventById(Long id);

    List<Event> getAll();

    void deactivateEvent(Long id);
}
