package com.rich.spring.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = "message", groupId = "group_1")
    public void consume(String message){
        log.info("Consumed Message: {}", message);
    }
}