package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "subscriptions",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "event_id"})
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /* -------------------- Audit Fields -------------------- */

    @Column(nullable = false, updatable = false)
    private LocalDateTime subscribedAt;

    /* -------------------- Lifecycle Hooks -------------------- */

    @PrePersist
    protected void onCreate() {
        this.subscribedAt = LocalDateTime.now();
    }
}
