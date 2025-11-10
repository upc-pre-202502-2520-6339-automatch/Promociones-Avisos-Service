package com.automatch.promotions.announcement.infrastructure.messaging.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${automatch.topic.producer}")
    private String producerTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPromotion(String message) {
        kafkaTemplate.send(producerTopic, message);
        System.out.println("PROMOTION EVENT PUBLISHED -> " + message);
    }
}