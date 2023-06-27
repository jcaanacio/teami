package com.bs280.teami.libraries;

import com.bs280.teami.libraries.interfaces.ITokenizationPayload;

public class TokenizationPayload implements ITokenizationPayload {

    private Long id;
    private String username;


    public TokenizationPayload (Long id, String username) {
        this.id = id;
        this.username = username;

    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    
}
