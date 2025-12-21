package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repo;

    public EventServiceImpl(EventRepository repo) {
        this.repo = repo;
    }

    public Event createEvent(Event event) {
        return repo.save(event);
    }

    public Event getEventById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Event> getAll() {
        return repo.findAll();
    }

    public void deactivateEvent(Long id) {
        Event e = getEventById(id);
        e.setActive(false);
        repo.save(e);
    }
}
