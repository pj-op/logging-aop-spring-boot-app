package com.logging.app.exceptions;

public class IncorrectArgException extends RuntimeException {
    public IncorrectArgException(String message) {
        super(message);
    }
}
