package com.bs280.teami.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bs280.teami.libraries.Auth;
import com.bs280.teami.models.Attendee;
import com.bs280.teami.services.AttendeeService;


@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeesService;

    @Auth
    @GetMapping
    public List<Attendee> list(){
        return attendeesService.list();
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

    @Auth
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
