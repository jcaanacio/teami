package com.bs280.teami.services;

import com.bs280.teami.models.Attendee;
import com.bs280.teami.repositories.AttendeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> list() {
        return attendeeRepository.findAll();
    }
    public Page<Attendee> getAllEntities(Pageable pageable) {
        return attendeeRepository.findAll(pageable);
    }

    public Attendee create(Attendee attendee) {
        return attendeeRepository.saveAndFlush(attendee);
    }

    public void delete(Long id){
        attendeeRepository.deleteById(id);
    }

    public Attendee get(Long id){
        return attendeeRepository.findById(id).orElse(null);
    }

    public Attendee update(Long id,Attendee attendee){
        Attendee existingAttendee = attendeeRepository.getReferenceById(id);
        BeanUtils.copyProperties(attendee, existingAttendee);
        return attendeeRepository.saveAndFlush(existingAttendee);
    }

}
