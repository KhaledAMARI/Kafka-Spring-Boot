package com.kafka.realTime.Controller;

import com.kafka.realTime.Service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody String message) {
        kafkaProducerService.sendMessage(message);
        return "Message published successfully!";
    }
}
