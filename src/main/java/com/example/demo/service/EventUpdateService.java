package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {
    EventUpdate createUpdate(Long eventId, String message);
    List<EventUpdate> getUpdatesByEvent(Long eventId);
    EventUpdate getUpdateById(Long id);
}
