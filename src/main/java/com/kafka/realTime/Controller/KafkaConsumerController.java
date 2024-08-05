package com.kafka.realTime.Controller;


import com.kafka.realTime.Service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaConsumerController {
    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @GetMapping("/messages")
    public List<String> getMessages(@RequestParam String topic) {
        System.out.println(topic);
        return kafkaConsumerService.getMessages(topic);
    }
}
