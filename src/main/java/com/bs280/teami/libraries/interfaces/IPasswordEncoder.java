package com.bs280.teami.libraries.interfaces;

public interface IPasswordEncoder {
    boolean isPasswordMatch(String inputPassword, String encodedPassword);
    String encode(String password);
    
}
