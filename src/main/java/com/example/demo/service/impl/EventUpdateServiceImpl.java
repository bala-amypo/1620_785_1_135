package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.service.EventUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    @Override
    public EventUpdate createUpdate(Long eventId, String message) {
        return new EventUpdate();
    }

    @Override
    public List<EventUpdate> getUpdatesByEvent(Long eventId) {
        return List.of();
    }

    @Override
    public EventUpdate getUpdateById(Long id) {
        return new EventUpdate();
    }
}
