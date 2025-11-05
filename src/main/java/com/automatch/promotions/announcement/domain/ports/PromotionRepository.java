package com.automatch.promotions.announcement.domain.ports;

import com.automatch.promotions.announcement.domain.model.Promotion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PromotionRepository {

    Promotion save(Promotion p);

    Optional<Promotion> findById(UUID id);

    List<Promotion> findAll();

    void deleteById(UUID id);
}