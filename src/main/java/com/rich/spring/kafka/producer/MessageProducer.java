package com.rich.spring.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducer {
    private static final String TOPIC = "message";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Producing message: {}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
