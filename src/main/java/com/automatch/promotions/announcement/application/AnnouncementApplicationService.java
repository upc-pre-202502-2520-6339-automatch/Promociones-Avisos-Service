package com.automatch.promotions.announcement.application;

import com.automatch.promotions.announcement.application.dto.CreateAnnouncementCommand;
import com.automatch.promotions.announcement.application.dto.UpdateAnnouncementCommand;
import com.automatch.promotions.announcement.domain.model.Announcement;
import com.automatch.promotions.announcement.domain.ports.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnnouncementApplicationService {

    private final AnnouncementRepository repository;

    public AnnouncementApplicationService(AnnouncementRepository repository) {
        this.repository = repository;
    }

    public Announcement create(CreateAnnouncementCommand cmd) {
        var a = new Announcement(
                null,
                cmd.title,
                cmd.message,
                cmd.expiresAt);
        return repository.save(a);
    }

    public List<Announcement> list() {
        return repository.findAll();
    }

    public Announcement update(UUID id, UpdateAnnouncementCommand cmd) {
        var p = repository.findById(id).orElseThrow();
        p.update(cmd.title, cmd.message);
        return repository.save(p);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}