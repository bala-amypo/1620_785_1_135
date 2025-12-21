package com.example.demo.controller;

import com.example.demo.model.Subscription;
import com.example.demo.service.SubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@Tag(name = "Subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // POST /{eventId} - Subscribe
    @PostMapping("/{eventId}")
    public ResponseEntity<Subscription> subscribe(@PathVariable Long eventId,
                                                   @RequestParam Long userId) {
        return ResponseEntity.ok(subscriptionService.subscribe(userId, eventId));
    }

    // DELETE /{eventId} - Unsubscribe
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> unsubscribe(@PathVariable Long eventId,
                                             @RequestParam Long userId) {
        subscriptionService.unsubscribe(userId, eventId);
        return ResponseEntity.noContent().build();
    }

    // GET /user/{userId} - List subscriptions
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionsByUser(userId));
    }

    // GET /check/{userId}/{eventId} - Check status
    @GetMapping("/check/{userId}/{eventId}")
    public ResponseEntity<Boolean> checkSubscription(
            @PathVariable Long userId,
            @PathVariable Long eventId) {
        return ResponseEntity.ok(subscriptionService.isSubscribed(userId, eventId));
    }
}