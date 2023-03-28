package com.bs280.teami.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bs280.teami.models.Attendee;
import com.bs280.teami.repositories.AttendeeRepository;


@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeRepository attendeesRepository;

    @GetMapping
    public List<Attendee> list(){
        return attendeesRepository.findAll();
    }
    
}
