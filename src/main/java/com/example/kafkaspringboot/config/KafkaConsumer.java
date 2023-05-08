package com.example.kafkaspringboot.config;


import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

import com.example.kafkaspringboot.dto.ResponseMan;

@EnableKafka
@Configuration
public class KafkaConsumer {
    @Value("${kafka.bootstrapAddress}")
    private String bootstrapServers;
    @Value("${kafka.consumer.consumer.auto-offset-reset}")
    private String autoOffsetResetConfig;
    @Value("${kafka.consumer.consumer.group-id}")
    private String rdbGroupId;

    @Bean
    public ConsumerFactory<String, ResponseMan> alarmEventRDBConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, rdbGroupId);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(ResponseMan.class));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ResponseMan> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ResponseMan> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setConsumerFactory(alarmEventRDBConsumerFactory()); // ConsumerFactory 설정 추가
        return factory;
    }

}
