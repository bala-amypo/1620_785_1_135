package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "broadcast_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    /* -------------------- Delivery Tracking -------------------- */

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus deliveryStatus = DeliveryStatus.SENT;

    @Column(nullable = false, updatable = false)
    private LocalDateTime sentAt;

    /* -------------------- Lifecycle Hooks -------------------- */

    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
        if (this.deliveryStatus == null) {
            this.deliveryStatus = DeliveryStatus.SENT;
        }
    }
}
