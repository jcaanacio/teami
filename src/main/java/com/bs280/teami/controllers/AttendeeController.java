package com.bs280.teami.controllers;

import com.bs280.teami.libraries.Auth;
import com.bs280.teami.models.Attendee;
import com.bs280.teami.repositories.AttendeeRepository;
import com.bs280.teami.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    private final AttendeeRepository attendeeRepository;
    @Autowired
    private AttendeeService attendeesService;

    public AttendeeController(AttendeeRepository attendeeRepository){
        this.attendeeRepository = attendeeRepository;
    }
    @Auth
    @GetMapping
    public ResponseEntity<Page<Attendee>> getAttendees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){

        Pageable pageable = PageRequest.of(page, size);
        Page<Attendee> attendees = attendeeRepository.findAll(pageable);
        return ResponseEntity.ok(attendees);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendee create(@RequestBody final Attendee attendee){
        return attendeesService.create(attendee);
    }

    @Auth
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        attendeesService.delete(id);
    }

    //@Auth
    @GetMapping()
    @RequestMapping("{id}")
    public Attendee get(@PathVariable Long id){
        return attendeesService.get(id);
    }

    @Auth
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Attendee update(@PathVariable Long id, @RequestBody Attendee attendee){
        return attendeesService.update(id,attendee);
    }

}
