package com.automatch.promotions.announcement.infrastructure.persistence;

import com.automatch.promotions.announcement.infrastructure.persistence.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnnouncementRepository extends JpaRepository<AnnouncementEntity, UUID> {
}