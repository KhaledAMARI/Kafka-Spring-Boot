package com.kafka.realTime;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class EshopController {

    @Autowired
    private KafkaProducer kafkaProducerService;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String requestBody = sb.toString();

        System.out.printf("Received: " + requestBody);
        kafkaProducerService.sendMessage(requestBody);
        System.out.println("Message sent to Kafka topic successfully!");
        // Process the request body
        return ResponseEntity.ok("Received: " + requestBody);
    }

}
