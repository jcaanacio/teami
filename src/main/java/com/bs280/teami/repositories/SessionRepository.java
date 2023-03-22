package com.bs280.teami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs280.teami.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}

