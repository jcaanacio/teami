package com.bs280.teami.libraries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bs280.teami.libraries.utils.Bs280Exception;
import com.bs280.teami.libraries.utils.ErrorResponse;
import com.bs280.teami.libraries.utils.ErrorScope;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        System.out.println("heeeeeeeee");
        System.out.println(ex);
       
        if (ex instanceof Bs280Exception) {
            Bs280Exception bs280Exception = (Bs280Exception) ex;
            ErrorResponse errorResponse = new ErrorResponse(bs280Exception.getMessage(), bs280Exception.getCode(), bs280Exception.getScope());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

        ErrorResponse errorResponse = new ErrorResponse("Error: " + ex.getMessage(), 500, ErrorScope.SERVER);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    
}

