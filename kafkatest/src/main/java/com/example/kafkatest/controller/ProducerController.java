package com.example.kafkatest.controller;

import com.example.kafkatest.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/save/{user}")
    public ResponseEntity<String> publishUser(@PathVariable("user") String user) {
        System.out.println("user: "+user);
        boolean b = producerService.publishUser(user);
        return ResponseEntity.ok(user);
    }

}
