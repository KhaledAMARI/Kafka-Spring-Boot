package com.kafka.realTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
public class RealTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeApplication.class, args);
	}

}
