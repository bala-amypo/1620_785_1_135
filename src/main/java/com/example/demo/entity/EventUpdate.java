package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    private String message;

    public Long getId() { return id; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
