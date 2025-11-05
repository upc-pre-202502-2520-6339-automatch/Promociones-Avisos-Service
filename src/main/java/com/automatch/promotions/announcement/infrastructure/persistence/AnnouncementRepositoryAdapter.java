package com.automatch.promotions.announcement.infrastructure.persistence;

import com.automatch.promotions.announcement.domain.ports.AnnouncementRepository;
import com.automatch.promotions.announcement.infrastructure.persistence.entity.AnnouncementEntity;
import com.automatch.promotions.announcement.domain.model.Announcement;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AnnouncementRepositoryAdapter implements AnnouncementRepository {

    private final JpaAnnouncementRepository jpa;

    public AnnouncementRepositoryAdapter(JpaAnnouncementRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Announcement save(Announcement announcement) {
        AnnouncementEntity entity = AnnouncementEntity.fromDomain(announcement);

        if (announcement.getId() == null) {
            entity.setId(null);
        }

        AnnouncementEntity saved = jpa.save(entity);
        return saved.toDomain();
    }

    @Override
    public Optional<Announcement> findById(UUID id) {
        return jpa.findById(id).map(AnnouncementEntity::toDomain);
    }

    @Override
    public List<Announcement> findAll() {
        return jpa.findAll().stream().map(AnnouncementEntity::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
}