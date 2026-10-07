package com.example.kafka_producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private static final String TOPIC = "mensajes";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, String message) {

        kafkaTemplate.send(TOPIC,key, message);

        System.out.println("Mensaje enviado a Kafka: " + message);
    }
}