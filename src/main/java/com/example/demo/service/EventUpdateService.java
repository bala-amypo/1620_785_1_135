package com.example.demo.service;

import com.example.demo.controller.EventUpdateRequest;
import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {
    List<EventUpdate> getUpdatesForEvent(Long eventId);
    EventUpdate publishUpdate(EventUpdateRequest request);
}
