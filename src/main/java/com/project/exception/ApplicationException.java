package com.project.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ApplicationException extends RuntimeException {
    private String message;

    public ApplicationException(String message){
        super(message);
    }
}
