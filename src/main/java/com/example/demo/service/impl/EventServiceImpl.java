package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Event createEvent(Event event) {
        User publisher = userRepository.findById(event.getPublisher().getId())
            .orElseThrow(() -> new RuntimeException("Publisher not found"));
        
        if (!publisher.getRole().equals(Role.PUBLISHER) && !publisher.getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("Only PUBLISHER or ADMIN can create events");
        }
        
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
                return eventRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<Event> getActiveEvents() {
        return eventRepository.findByIsActiveTrue();
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public void deactivateEvent(Long id) {
        eventRepository.findById(id)
            .ifPresentOrElse(event -> {
                event.setActive(false);
                eventRepository.save(event);
            }, () -> {
                throw new RuntimeException("Event not found");
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
