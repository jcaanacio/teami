package com.bs280.teami.libraries.interfaces;



public interface ITokenization {
    boolean verify(String token);
    String sign(ITokenizationPayload payload);
    String refresh(String token);
}
