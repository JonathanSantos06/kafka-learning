package com.example.kafka_consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {

    @KafkaListener(
            topics = "mensajes",
            groupId = "kafka-learning-group"
    )
    public void consume(String message) {

        System.out.println(
                "Mensaje recibido desde Kafka: " + message
        );
    }
}