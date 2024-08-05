package com.kafka.realTime.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class KafkaConsumerService {

    private final ConcurrentMap<String, List<String>> messages = new ConcurrentHashMap<>();

    @Value("${kafka.topic}")
    private String TOPIC;

    @Value("${kafka.group.id}")
    private String ID;

    @KafkaListener(topics = "#{'${kafka.topic}'}", groupId = "#{'${kafka.group.id}'}")
    public void listen(ConsumerRecord<String, String> record) {
        String topic = record.topic();
        // Ensure the topic exists in the map
        messages.computeIfAbsent(topic, k -> new ArrayList<>()).add(record.value());
        // Optionally, log received messages for debugging
        System.out.println("Received message from topic " + topic + ": " + record.value());
    }

    public List<String> getMessages(String topic) {
        // Retrieve messages for the specified topic
        return messages.getOrDefault(topic, new ArrayList<>());
    }

    // Optionally, provide a method to clear messages (if needed)
    public void clearMessages(String topic) {
        messages.remove(topic);
    }
}

