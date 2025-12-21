package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {
    EventUpdate createUpdate(Long eventId, String message);
    List<EventUpdate> getUpdatesForEvent(Long eventId);
}
