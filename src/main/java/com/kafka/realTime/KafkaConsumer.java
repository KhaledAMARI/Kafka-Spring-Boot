package com.kafka.realTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test1", groupId = "1")
    public void listen(String message) {
        System.out.println("Received Message in group my-group: " + message);
    }
}

