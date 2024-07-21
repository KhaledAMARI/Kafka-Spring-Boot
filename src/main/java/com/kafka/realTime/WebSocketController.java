package com.kafka.realTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSocketController {


    @GetMapping("/test")
    @ResponseBody
    public String getTestPage() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>WebSocket Test</title>" +
                "<script type='text/javascript'>" +
                "var ws;" +
                "function connect() {" +
                "  ws = new WebSocket('ws://' + window.location.host + '/ws');" +
                "  ws.onmessage = function(event) {" +
                "    var messages = document.getElementById('messages');" +
                "    messages.innerHTML += '<br/>' + event.data;" +
                "  };" +
                "}" +
                "function send() {" +
                "  var message = document.getElementById('message').value;" +
                "  ws.send(message);" +
                "}" +
                "</script>" +
                "</head>" +
                "<body>" +
                "<button onclick='connect()'>Connect</button><br/>" +
                "<input type='text' id='message'/>" +
                "<button onclick='send()'>Send</button><br/>" +
                "<div id='messages'></div>" +
                "</body>" +
                "</html>";
    }
}
