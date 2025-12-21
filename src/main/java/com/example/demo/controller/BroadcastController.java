package com.example.demo.controller;

import com.example.demo.service.BroadcastLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broadcast")
public class BroadcastController {

    private final BroadcastLogService broadcastLogService;

    public BroadcastController(BroadcastLogService broadcastLogService) {
        this.broadcastLogService = broadcastLogService;
    }

    @PostMapping("/{updateId}")
    public void trigger(@PathVariable Long updateId) {
        broadcastLogService.triggerBroadcast(updateId);
    }
}
