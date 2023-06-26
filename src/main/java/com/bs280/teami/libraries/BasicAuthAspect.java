package com.bs280.teami.libraries;

import com.bs280.teami.libraries.utils.Bs280Exception;
import com.bs280.teami.libraries.utils.ErrorScope;
import java.util.Base64;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class BasicAuthAspect {
    @Before("@annotation(com.bs280.teami.libraries.BasicAuth)")
    public void basicAuth() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        if (requestAttributes == null) {
            throw new Bs280Exception("Could not retrieve HTTP request", 400, ErrorScope.CLIENT);
        }

        HttpServletRequest request = requestAttributes.getRequest();
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            throw new Bs280Exception("Basic token is missing or invalid", 401, ErrorScope.CLIENT);
        }

        String username = getUsernameFromAuthorization(authorizationHeader);
        String password = getPasswordFromAuthorization(authorizationHeader);
        UserInput requestBody = new UserInput(username,password);

        request.setAttribute("requestBody", requestBody);
    }

    private String getUsernameFromAuthorization(String authorization) {
        if (authorization != null && authorization.startsWith("Basic ")) {
            String base64Credentials = authorization.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            return credentials.split(":", 2)[0];
        }
        return null;
    }

    private String getPasswordFromAuthorization(String authorization) {
        if (authorization != null && authorization.startsWith("Basic ")) {
            String base64Credentials = authorization.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            return credentials.split(":", 2)[1];
        }
        return null;
    }
}
