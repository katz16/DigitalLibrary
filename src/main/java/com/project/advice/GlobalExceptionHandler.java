package com.project.advice;

import com.project.exception.ApplicationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public String handleApplicationException(ApplicationException ex) {
        System.out.println(ex.getMessage());
        return ex.getMessage();
    }
}
