package com.kafka.realTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {


    private final WebSocketService webSocketService;

    public KafkaConsumer(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    //@KafkaListener(topics = "test1", groupId = "1")
    public void consume(String message) {
        // Forward the Kafka message to WebSocket clients
        this.webSocketService.sendMessage(message);
    }

}

