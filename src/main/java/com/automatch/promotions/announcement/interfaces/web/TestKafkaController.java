package com.automatch.promotions.announcement.interfaces.web;

import com.automatch.promotions.announcement.infrastructure.messaging.producer.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestKafkaController {

    private final ProducerService producerService;

    public TestKafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/kafka/promocion/{msg}")
    public String sendPromotion(@PathVariable String msg) {
        producerService.publishPromotion(msg);
        return "Promoción publicada -> " + msg;
    }
}