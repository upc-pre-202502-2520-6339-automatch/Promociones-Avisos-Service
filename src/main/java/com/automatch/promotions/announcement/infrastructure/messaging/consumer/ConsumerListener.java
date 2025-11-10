package com.automatch.promotions.announcement.infrastructure.messaging.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @KafkaListener(topics = "${automatch.topic.consumer}", groupId = "promotions-service-group")
    public void consume(String message) {
        System.out.println("promotions-service RECEIVED INTERACTION EVENT -> " + message);
    }
}