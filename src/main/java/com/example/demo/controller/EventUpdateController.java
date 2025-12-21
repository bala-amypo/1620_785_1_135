package com.example.demo.controller;
import com.example.demo.entity.EventUpdate;

// import com.example.demo.dto.EventUpdateRequest;
import com.example.demo.model.EventUpdateController;
import com.example.demo.service.EventUpdateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/updates")
@Tag(name = "Event Updates")
public class EventUpdateController {

    private final EventUpdateService eventUpdateService;

    public EventUpdateController(EventUpdateService eventUpdateService) {
        this.eventUpdateService = eventUpdateService;
    }

    // POST / – Publish update
    @PostMapping
    public ResponseEntity<EventUpdateController> publishUpdate(
            @RequestBody EventUpdateRequest request) {
        return ResponseEntity.ok(eventUpdateService.publishUpdate(request));
    }

    // GET /event/{eventId} – Get updates for event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventUpdate>> getUpdatesByEvent(
            @PathVariable Long eventId) {
        return ResponseEntity.ok(eventUpdateService.getUpdatesByEvent(eventId));
    }

    // GET /{id} – Get update by ID
    @GetMapping("/{id}")
    public ResponseEntity<EventUpdate> getUpdateById(@PathVariable Long id) {
        return ResponseEntity.ok(eventUpdateService.getUpdateById(id));
    }
}