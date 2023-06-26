package com.bs280.teami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs280.teami.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

