package com.example.kafkaspringboot.kafkaService;

import com.example.kafkaspringboot.DTO.ResponseMan;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;


@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "rapa-auto-ever", groupId = "rapa-auto-ever-group",
            properties = {AUTO_OFFSET_RESET_CONFIG + ":earliest"},
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(ResponseMan message) {
        log.warn("메시지: " + message.toString());
    }
}

