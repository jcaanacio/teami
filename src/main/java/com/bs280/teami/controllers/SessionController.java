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
import com.bs280.teami.models.Session;
import com.bs280.teami.services.SessionService;

@RestController
@RequestMapping("/api/v1/sessions")

public class SessionController {
    @Autowired
    private SessionService sessionService;

    @Auth
    @GetMapping
    public List<Session> list() {
        return sessionService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
        return sessionService.create(session);
    }

    @Auth
    @GetMapping()
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionService.get(id);
    }

    @Auth
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }

    @Auth
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return sessionService.update(id,session);

    }
}
