package com.automatch.promotions.announcement.application.dto;

import java.time.LocalDate;

public class CreatePromotionCommand {
        public String title;
        public String description;
        public double discountPercentage;
        public LocalDate validUntil;
}
