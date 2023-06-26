package com.bs280.teami.libraries.interfaces;

import com.bs280.teami.libraries.TokenizationPayload;

public interface ITokenization {
    boolean verify(String token);
    String sign(TokenizationPayload payload);
    String refresh(String token);
}
