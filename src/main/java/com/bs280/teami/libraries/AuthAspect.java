package com.bs280.teami.libraries;

import com.bs280.teami.libraries.utils.Bs280Exception;
import com.bs280.teami.libraries.utils.ErrorScope;
import com.bs280.teami.services.AuthService;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthAspect {
    @Autowired
    private AuthService authService;
    @Before("@annotation(com.bs280.teami.libraries.Auth)")
    public void auth() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        if (requestAttributes == null) {
            throw new Bs280Exception("Could not retrieve HTTP request", 400, ErrorScope.CLIENT);
        }

        HttpServletRequest request = requestAttributes.getRequest();
        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new Bs280Exception("Bearer token is missing or invalid", 401, ErrorScope.CLIENT);
        }

        String token = authorization.substring(7);

        Boolean isVerified = this.authService.verify(token);

        System.out.println(token);
        System.out.println(isVerified);

        if(isVerified == false) {
            throw new Bs280Exception("Invalid token", 401, ErrorScope.CLIENT);
        }

        /**
         * TODO: JWT IMPLEMENTATION
         * Interface Tokenization {
         *      sign()
         *      verify()
         *      refresh()
         * }
         */
    }
}
