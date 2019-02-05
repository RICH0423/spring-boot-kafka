package com.rich.spring.kafka.controller;

import com.rich.spring.kafka.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    private final MessageProducer producer;

    @Autowired
    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void sendMessageToKafka(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }
}
