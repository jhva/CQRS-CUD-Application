package com.example.kafkaspringboot.kafkaService;

import com.example.kafkaspringboot.dto.RequestDtoKid;
import com.example.kafkaspringboot.dto.ResponseMan;
import com.example.kafkaspringboot.entity.Kid;
import com.example.kafkaspringboot.repository.ManRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.common.security.token.delegation.DelegationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    @Value("topic-kid")
    private String topicName;
    private final KafkaTemplate<String, ResponseMan> kafkaTemplate;
    private final ManRepository manRepository;

    public ResponseMan sendMessage(RequestDtoKid dto) {

        Kid kid = Kid.builder().
            name(dto.getName())
            .age(dto.getAge())
            .job(dto.getJob())
            .githubUrl(dto.getGithubUrl())
            .hobby(dto.getHobby())
            .height(dto.getHeight())
            .tech(dto.getTech())
            .build();

        Kid saveMan = manRepository.save(kid);

        ResponseMan responseMan = ResponseMan.builder().
            name(saveMan.getName())
            .age(saveMan.getAge())
            .job(saveMan.getJob())
            .githubUrl(saveMan.getGithubUrl())
            .hobby(saveMan.getHobby())
            .height(saveMan.getHeight())
            .tech(saveMan.getTech())
            .build();

        //이벤트 발생
        kafkaTemplate.send(topicName, responseMan);
        return responseMan;
    }
}
