package com.example.demo.entity;

public class Event {
    private String title;
    private String description;
    private boolean active = true;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
