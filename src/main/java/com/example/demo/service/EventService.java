package com.example.demo.service;

import com.example.demo.model.Event;
import java.util.List;

public interface EventService {
    Event create(Event event);
    List<Event> getAll();
}
