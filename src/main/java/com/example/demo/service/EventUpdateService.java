package com.example.demo.service;

import com.example.demo.controller.EventUpdateRequest;
import com.example.demo.entity.EventUpdate;

public interface EventUpdateService {
    EventUpdate publishUpdate(EventUpdateRequest request);
}
