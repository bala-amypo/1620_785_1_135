package com.example.demo.controller;

import com.example.demo.service.BroadcastLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/broadcasts")
public class BroadcastController {

    private final BroadcastLogService broadcastLogService;

    public BroadcastController(BroadcastLogService broadcastLogService) {
        this.broadcastLogService = broadcastLogService;
    }

    @PostMapping("/{eventUpdateId}")
    public ResponseEntity<Void> triggerBroadcast(@PathVariable Long eventUpdateId) {
        broadcastLogService.triggerBroadcast(eventUpdateId);
        return ResponseEntity.ok().build();
    }
}
