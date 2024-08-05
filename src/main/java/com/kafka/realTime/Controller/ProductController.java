package com.kafka.realTime.Controller;

import com.kafka.realTime.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class ProductController {

    @Autowired
    private ProductService eshopService;

    @PostMapping
    public String placeOrder(@RequestBody Object data) {
        return eshopService.getOrder(data);
    }
}
