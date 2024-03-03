package com.example.kafkatest.service.impl;

import com.example.kafkatest.common.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service("consumerService")
public class ConsumerServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @KafkaListener(topics = "kafkaTopic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: "+message);
    }

}
