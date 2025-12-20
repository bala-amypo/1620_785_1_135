package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event_updates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String updateContent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UpdateType updateType;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    @Column
    private SeverityLevel severityLevel = SeverityLevel.LOW;

    /* -------------------- Broadcast Logs -------------------- */


    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
        if (this.severityLevel == null) {
            this.severityLevel = SeverityLevel.LOW;
        }
    }
}
