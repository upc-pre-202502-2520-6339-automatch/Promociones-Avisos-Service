package com.automatch.promotions.announcement.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Announcement {

    private UUID id;
    private String title;
    private String message;
    private LocalDate expiresAt;

    public Announcement(UUID id, String title, String message, LocalDate expiresAt) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.expiresAt = expiresAt;
    }

    public void update(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }
}