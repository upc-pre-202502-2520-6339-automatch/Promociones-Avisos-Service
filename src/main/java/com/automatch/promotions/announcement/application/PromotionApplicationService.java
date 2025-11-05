package com.automatch.promotions.announcement.application;

import com.automatch.promotions.announcement.application.dto.CreatePromotionCommand;
import com.automatch.promotions.announcement.application.dto.UpdatePromotionCommand;
import com.automatch.promotions.announcement.domain.model.Promotion;
import com.automatch.promotions.announcement.domain.ports.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PromotionApplicationService {

    private final PromotionRepository repository;

    public PromotionApplicationService(PromotionRepository repository) {
        this.repository = repository;
    }

    public Promotion create(CreatePromotionCommand cmd) {
        var p = new Promotion(
                null,
                cmd.title,
                cmd.description,
                cmd.discountPercentage,
                cmd.validUntil);
        return repository.save(p);
    }

    public List<Promotion> list() {
        return repository.findAll();
    }

    public Promotion update(UUID id, UpdatePromotionCommand cmd) {
        var p = repository.findById(id).orElseThrow();
        p.update(cmd.title, cmd.description);
        return repository.save(p);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}