package com.example.kafkatest.service.impl;

import com.example.kafkatest.common.AppConstants;
import com.example.kafkatest.model.User;
import com.example.kafkatest.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public ProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public boolean publishUser(String message) {
        this.kafkaTemplate.send(AppConstants.KAFKA_TOPIC,message);
        System.out.println("Message send: "+message);
        return true;
    }

}
