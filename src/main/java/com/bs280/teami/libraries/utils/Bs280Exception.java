package com.bs280.teami.libraries.utils;

public class Bs280Exception extends RuntimeException implements Bs280Error {

    private String message;
    private int code;
    private ErrorScope scope;

    public Bs280Exception(String message, int code, ErrorScope scope) {
        super(message);
        this.message = message;
        this.code = code;
        this.scope = scope;
    }

    public Bs280Exception(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public int getCode() {
        
        return code;
    }
 
    public ErrorScope getScope() {
       return scope;
    }

    public String getMessage() {
        return message;
    }
}
