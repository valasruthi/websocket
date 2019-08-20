package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebsocketController(SimpMessagingTemplate messagingTemplate)
    {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/send/message")
    public void recievedMessage(String message) throws Exception{
        Thread.sleep(1000);
        this.messagingTemplate.convertAndSend("/chat",message);
    }
}
