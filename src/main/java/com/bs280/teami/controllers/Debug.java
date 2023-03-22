package com.bs280.teami.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/debug")
public class Debug {

    @RequestMapping(method = RequestMethod.GET)
    public void get() {
        System.out.println("Here===============");
    }

    @PostMapping
    public Map<String, Object> post() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jay");
        map.put("results", "hello");
        return map;
    }

}
