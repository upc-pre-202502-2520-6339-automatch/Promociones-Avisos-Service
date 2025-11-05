package com.automatch.promotions.announcement.infrastructure.persistence.entity;

import com.automatch.promotions.announcement.domain.model.Announcement;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "announcements")
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String message;
    private LocalDate expiresAt;

    @Version
    private Long version = 0L;

    public Announcement toDomain() {
        return new Announcement(id, title, message, expiresAt);
    }

    public static AnnouncementEntity create(String title, String message, LocalDate expiresAt) {
        var a = new AnnouncementEntity();
        a.title = title;
        a.message = message;
        a.expiresAt = expiresAt;
        return a;
    }

    public static AnnouncementEntity restore(UUID id, String title, String message, LocalDate expiresAt) {
        var a = new AnnouncementEntity();
        a.id = id;
        a.title = title;
        a.message = message;
        a.expiresAt = expiresAt;
        return a;
    }

    public static AnnouncementEntity fromDomain(Announcement a) {
        var e = new AnnouncementEntity();
        if (a.getId() != null)
            e.id = a.getId();
        e.title = a.getTitle();
        e.message = a.getMessage();
        e.expiresAt = a.getExpiresAt();
        return e;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setExpiresAt(LocalDate expiresAt) {
        this.expiresAt = expiresAt;
    }
}