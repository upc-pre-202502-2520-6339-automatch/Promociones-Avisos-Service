package com.automatch.promotions.announcement.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Promotion {

    private UUID id;
    private String title;
    private String description;
    private final double discountPercentage;
    private final LocalDate validUntil;

    public Promotion(UUID id, String title, String description, double discountPercentage, LocalDate validUntil) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.validUntil = validUntil;
    }

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
}