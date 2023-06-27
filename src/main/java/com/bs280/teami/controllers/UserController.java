package com.bs280.teami.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import com.bs280.teami.libraries.BasicAuth;
import com.bs280.teami.libraries.UserInput;
import com.bs280.teami.models.User;
import com.bs280.teami.services.UserService;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    // @Auth
    @GetMapping
    public List<User> list(){
        return userService.list();
    }

    @BasicAuth
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(HttpServletRequest request){
        UserInput username = (UserInput) request.getAttribute("requestBody");
        return userService.create(username);
    }

}
