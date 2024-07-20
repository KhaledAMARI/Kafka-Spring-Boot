package com.kafka.realTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class RealTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeApplication.class, args);
	}

}
