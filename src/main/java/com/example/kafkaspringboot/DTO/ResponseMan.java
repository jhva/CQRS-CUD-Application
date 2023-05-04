package com.example.kafkaspringboot.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseMan {

    private Long id;

    private String name;

    private int age;

    private String hobby;

    private int height;

    private String job;

    private String tech;

    private String githubUrl;

}
