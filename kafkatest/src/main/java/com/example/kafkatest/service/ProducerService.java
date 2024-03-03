package com.example.kafkatest.service;

import com.example.kafkatest.model.User;

public interface ProducerService {

    boolean publishUser(String user);

}
