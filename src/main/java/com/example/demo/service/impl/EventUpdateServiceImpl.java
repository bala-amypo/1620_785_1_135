package com.example.demo.service.impl;

import com.example.demo.controller.EventUpdateRequest;
import com.example.demo.entity.EventUpdate;
import com.example.demo.service.EventUpdateService;
import org.springframework.stereotype.Service;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    @Override
    public EventUpdate publishUpdate(EventUpdateRequest request) {
        EventUpdate update = new EventUpdate();
        update.setMessage(request.getMessage());
        return update;
    }
}
