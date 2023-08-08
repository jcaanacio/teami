package com.bs280.teami.controllers;

import com.bs280.teami.libraries.BasicAuth;
import com.bs280.teami.libraries.UserInput;
import com.bs280.teami.models.User;
import com.bs280.teami.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        UserInput userInput = (UserInput) request.getAttribute("requestBody");
        User user = new User();
        user.setUsername(userInput.getUsername());
        user.setPassword(userInput.getPassword());
        return userService.create(user);
    }

}
