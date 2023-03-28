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
import com.bs280.teami.models.Speaker;
import com.bs280.teami.services.SpeakerService;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {


    @Autowired
    private SpeakerService speakerService;

    @GetMapping
    public List<Speaker> list() {
        return speakerService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerService.create(speaker);
    }


    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerService.get(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        /**
         * TODO: Cascade delete
         */
        speakerService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        /**
         * TODO: Add validation that all attributes are passed in, otherwise return 400
         */
        return speakerService.update(id, speaker);
    }
}
