package com.automatch.promotions.announcement.domain.ports;

import com.automatch.promotions.announcement.domain.model.Announcement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnnouncementRepository {

    Announcement save(Announcement announcement);

    Optional<Announcement> findById(UUID id);

    List<Announcement> findAll();

    void deleteById(UUID id);
}