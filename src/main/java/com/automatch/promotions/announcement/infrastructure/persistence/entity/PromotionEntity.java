package com.automatch.promotions.announcement.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

import com.automatch.promotions.announcement.domain.model.Promotion;

@Entity
@Table(name = "promotions")
public class PromotionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private double discountPercentage;
    private LocalDate validUntil;

    @Version
    private Long version = 0L;

    protected PromotionEntity() {
    }

    // FACTORY
    public static PromotionEntity create(String title, String description, double discountPercentage,
            LocalDate validUntil) {
        var p = new PromotionEntity();
        p.title = title;
        p.description = description;
        p.discountPercentage = discountPercentage;
        p.validUntil = validUntil;
        return p;
    }

    public Promotion toDomain() {
        return new Promotion(id, title, description, discountPercentage, validUntil);
    }

    public static PromotionEntity fromDomain(Promotion p) {
        var e = new PromotionEntity();
        e.id = p.getId();
        e.title = p.getTitle();
        e.description = p.getDescription();
        e.discountPercentage = p.getDiscountPercentage();
        e.validUntil = p.getValidUntil();
        return e;
    }

    // UPDATE
    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}