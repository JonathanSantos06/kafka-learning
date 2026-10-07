package com.example.kafka_producer.controller;

import com.example.kafka_producer.producer.KafkaMessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaMessageProducer producer;

    public MessageController(KafkaMessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestParam String key,
            @RequestBody String message) {

        producer.sendMessage(key, message);

        return ResponseEntity.ok("Mensaje enviado a Kafka");
    }
}