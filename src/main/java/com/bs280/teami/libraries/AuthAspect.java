package com.bs280.teami.libraries;

import com.bs280.teami.libraries.utils.Bs280Exception;
import com.bs280.teami.libraries.utils.ErrorScope;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthAspect {
    @Before("@annotation(com.bs280.teami.libraries.Auth)")
    public void auth() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        if (requestAttributes == null) {
            throw new Bs280Exception("Could not retrieve HTTP request", 400, ErrorScope.CLIENT);
        }

        HttpServletRequest request = requestAttributes.getRequest();
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new Bs280Exception("Bearer token is missing or invalid", 401, ErrorScope.CLIENT);
        }



        String decoded = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";


        if (authorizationHeader != decoded) {
            throw new Bs280Exception("Bearer token is missing or invalid", 401, ErrorScope.CLIENT);
        }

        if (authorizationHeader != decoded) {
            throw new Bs280Exception("Bearer token is missing or invalid", 401, ErrorScope.CLIENT);
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
