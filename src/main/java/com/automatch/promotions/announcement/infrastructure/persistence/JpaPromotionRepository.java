package com.automatch.promotions.announcement.infrastructure.persistence;

import com.automatch.promotions.announcement.infrastructure.persistence.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPromotionRepository extends JpaRepository<PromotionEntity, UUID> {
}