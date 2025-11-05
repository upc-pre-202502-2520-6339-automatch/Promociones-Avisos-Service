package com.automatch.promotions.announcement.interfaces.web;

import com.automatch.promotions.announcement.application.PromotionApplicationService;
import com.automatch.promotions.announcement.application.dto.CreatePromotionCommand;
import com.automatch.promotions.announcement.application.dto.UpdatePromotionCommand;
import com.automatch.promotions.announcement.domain.model.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    private final PromotionApplicationService app;

    public PromotionController(PromotionApplicationService app) {
        this.app = app;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreatePromotionCommand cmd) {
        Promotion p = app.create(cmd);
        return ResponseEntity.ok(Map.of(
                "id", p.getId(),
                "title", p.getTitle()));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(app.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody UpdatePromotionCommand cmd) {
        var p = app.update(id, cmd);
        return ResponseEntity.ok(Map.of("updatedId", p.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        app.delete(id);
        return ResponseEntity.ok().build();
    }
}