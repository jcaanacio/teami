package com.bs280.teami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs280.teami.models.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    
}
