package com.bs280.teami.libraries.utils;

public interface Bs280Error {
    String getMessage();
    int getCode();
    ErrorScope getScope();
}
