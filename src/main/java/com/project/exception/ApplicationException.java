package com.project.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private String message;
}
