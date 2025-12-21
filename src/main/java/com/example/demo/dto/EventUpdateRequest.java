package com.example.demo.dto;

public class EventUpdateRequest {
    private Long eventId;
    private String message;

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
