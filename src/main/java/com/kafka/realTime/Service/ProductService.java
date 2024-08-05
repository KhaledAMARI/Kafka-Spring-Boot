package com.kafka.realTime.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public String getOrder(Object data) {
        kafkaProducerService.sendMessage(data.toString());
        return "data = "+ data.toString();
    }
}
