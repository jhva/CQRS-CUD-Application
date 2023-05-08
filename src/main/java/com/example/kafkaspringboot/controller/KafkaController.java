package com.example.kafkaspringboot.controller;

import com.example.kafkaspringboot.config.KafkaProducer;
import com.example.kafkaspringboot.dto.RequestDtoKid;
import com.example.kafkaspringboot.dto.ResponseMan;
import com.example.kafkaspringboot.kafkaService.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaspringboot.repository.ManRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KafkaController {

    private final ProducerService producerService;

    @PostMapping("/man/save")
    public ResponseEntity saveMan(@RequestBody RequestDtoKid dto) {
        // return ResponseEntity.ok()
        ResponseMan responseMan = producerService.sendMessage(dto);
        return ResponseEntity.ok().body(responseMan);
    }
}
