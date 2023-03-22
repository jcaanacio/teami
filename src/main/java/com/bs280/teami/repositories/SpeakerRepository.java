package com.bs280.teami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs280.teami.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}

