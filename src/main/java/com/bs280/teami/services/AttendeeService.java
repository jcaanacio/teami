package com.bs280.teami.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs280.teami.models.Attendee;
import com.bs280.teami.repositories.AttendeeRepository;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> list() {
        return attendeeRepository.findAll();
    }

    public Attendee create(Attendee attendee) {
        return attendeeRepository.saveAndFlush(attendee);
    }

}
