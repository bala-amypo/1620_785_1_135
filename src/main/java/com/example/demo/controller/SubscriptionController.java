package com.example.demo.controller;

import com.example.demo.entity.Subscription;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @PostMapping
    public Subscription subscribe(@RequestBody Subscription subscription) {
        return subscription;
    }
}
