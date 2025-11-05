package com.automatch.promotions.announcement.infrastructure.persistence;

import com.automatch.promotions.announcement.domain.model.Promotion;
import com.automatch.promotions.announcement.domain.ports.PromotionRepository;
import com.automatch.promotions.announcement.infrastructure.persistence.entity.PromotionEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PromotionRepositoryAdapter implements PromotionRepository {

    private final JpaPromotionRepository jpa;

    public PromotionRepositoryAdapter(JpaPromotionRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Promotion save(Promotion promotion) {
        PromotionEntity entity = PromotionEntity.fromDomain(promotion);
        PromotionEntity saved = jpa.save(entity);
        return saved.toDomain();
    }

    @Override
    public Optional<Promotion> findById(UUID id) {
        return jpa.findById(id).map(PromotionEntity::toDomain);
    }

    @Override
    public List<Promotion> findAll() {
        return jpa.findAll().stream().map(PromotionEntity::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
}