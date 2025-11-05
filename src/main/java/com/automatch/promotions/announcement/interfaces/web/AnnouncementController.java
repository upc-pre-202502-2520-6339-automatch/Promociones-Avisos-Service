package com.automatch.promotions.announcement.interfaces.web;

import com.automatch.promotions.announcement.application.AnnouncementApplicationService;
import com.automatch.promotions.announcement.application.dto.CreateAnnouncementCommand;
import com.automatch.promotions.announcement.application.dto.UpdateAnnouncementCommand;
import com.automatch.promotions.announcement.domain.model.Announcement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementController {

    private final AnnouncementApplicationService app;

    public AnnouncementController(AnnouncementApplicationService app) {
        this.app = app;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateAnnouncementCommand cmd) {
        Announcement a = app.create(cmd);
        return ResponseEntity.ok(Map.of(
                "id", a.getId(),
                "title", a.getTitle()));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(app.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody UpdateAnnouncementCommand cmd) {
        var a = app.update(id, cmd);
        return ResponseEntity.ok(Map.of("updatedId", a.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        app.delete(id);
        return ResponseEntity.ok().build();
    }
}