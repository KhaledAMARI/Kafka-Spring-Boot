package com.kafka.realTime;

import org.springframework.stereotype.Service;

@Service
public class WebSocketService {


    private final WebSockerHandler webSocketHandler;

    public WebSocketService(WebSockerHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    public void sendMessage(String message) {
        webSocketHandler.broadcast(message);
    }
}
