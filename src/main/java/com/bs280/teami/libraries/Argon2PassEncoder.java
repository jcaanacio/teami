package com.bs280.teami.libraries;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import com.bs280.teami.libraries.interfaces.IPasswordEncoder;

public class Argon2PassEncoder implements IPasswordEncoder {

    private Argon2PasswordEncoder _encoder = new Argon2PasswordEncoder();

    @Override
    public String encode(String password) {
       return this._encoder.encode(password);
    }

    @Override
    public boolean isPasswordMatch(String inputPassword, String encodedPassword) {
        return  this._encoder.matches(inputPassword, encodedPassword);
    }
    
}
