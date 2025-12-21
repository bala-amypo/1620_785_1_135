package com.example.demo.controller;

import com.example.demo.model.BroadcastLog;
import com.example.demo.service.BroadcastLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/broadcasts")
@Tag(name = "Broadcasts")
public class BroadcastLogService {

    private final BroadcastLogService broadcastService;

    public BroadcastController(BroadcastLogService broadcastService) {
        this.broadcastService = broadcastService;
    }

    // POST /trigger/{updateId} - Manual broadcast trigger
    @PostMapping("/trigger/{updateId}")
    public ResponseEntity<Void> triggerBroadcast(@PathVariable Long updateId) {
        broadcastService.triggerBroadcast(updateId);
        return ResponseEntity.ok().build();
    }

    // GET /logs/{updateId} - Get logs
    @GetMapping("/logs/{updateId}")
    public ResponseEntity<List<BroadcastLog>> getLogs(@PathVariable Long updateId) {
        return ResponseEntity.ok(broadcastService.getLogsForUpdate(updateId));
    }
}