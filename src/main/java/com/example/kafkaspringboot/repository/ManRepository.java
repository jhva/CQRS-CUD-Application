package com.example.kafkaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkaspringboot.entity.Kid;

@Repository
public interface ManRepository extends JpaRepository<Kid, Long> {
}
