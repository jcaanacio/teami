package com.bs280.teami.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import com.bs280.teami.libraries.BasicAuth;
import com.bs280.teami.libraries.TokenResponse;
import com.bs280.teami.libraries.UserInput;
import com.bs280.teami.services.AuthService;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @BasicAuth
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse sign(HttpServletRequest request){
        UserInput userInput = (UserInput) request.getAttribute("requestBody");
        TokenResponse reponse = new TokenResponse(authService.sign(userInput));
        return reponse;
    }

}
