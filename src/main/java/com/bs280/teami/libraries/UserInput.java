package com.bs280.teami.libraries;

import org.springframework.stereotype.Component;

@Component
public class UserInput {
    private String username;
    private String password;

    
    public UserInput() {
    }

    public UserInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}