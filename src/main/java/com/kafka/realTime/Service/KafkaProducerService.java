package com.kafka.realTime.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String TOPIC;

//    private static final String TOPIC = "test1";

    public void sendMessage(String message) {
        System.out.println(TOPIC);
        kafkaTemplate.send(TOPIC, message);
    }
}
