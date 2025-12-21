package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventRepository eventRepo;
    private final EventUpdateRepository updateRepo;

    public EventUpdateServiceImpl(EventRepository eventRepo,
                                  EventUpdateRepository updateRepo) {
        this.eventRepo = eventRepo;
        this.updateRepo = updateRepo;
    }

    public EventUpdate createUpdate(Long eventId, String message) {
        Event event = eventRepo.findById(eventId).orElseThrow();
        EventUpdate u = new EventUpdate();
        u.setEvent(event);
        u.setMessage(message);
        return updateRepo.save(u);
    }

    public List<EventUpdate> getUpdatesForEvent(Long eventId) {
        return updateRepo.findByEventId(eventId);
    }
}
