package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        return eventRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(event.getTitle());
                    existing.setDescription(event.getDescription());
                    existing.setLocation(event.getLocation());
                    existing.setCategory(event.getCategory());
                    existing.setActive(event.isActive());
                    return eventRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<Event> getActiveEvents() {
        return eventRepository.findByActiveTrue();
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public void deactivateEvent(Long id) {
        eventRepository.findById(id).ifPresent(event -> {
            event.setActive(false);
            eventRepository.save(event);
        });
    }

    @Override
    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public Event getEventById(Long id) {
        return getById(id);
    }
}
