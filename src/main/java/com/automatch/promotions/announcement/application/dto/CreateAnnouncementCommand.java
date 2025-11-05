package com.automatch.promotions.announcement.application.dto;

import java.time.LocalDate;

public class CreateAnnouncementCommand {
        public String title;
        public String message;
        public LocalDate expiresAt;
}