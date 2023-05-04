package com.example.kafkaspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Kid {
    @Id
    private Long id;

    private String name;

    private int age;

    private String hobby;

    private int height;

    private String job;

    private String tech;

    private String githubUrl;
}
