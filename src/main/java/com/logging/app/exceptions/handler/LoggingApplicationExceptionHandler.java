package com.logging.app.exceptions.handler;

import com.logging.app.exceptions.IncorrectArgException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class LoggingApplicationExceptionHandler {

    @ExceptionHandler(value = IncorrectArgException.class)
    public ResponseEntity<String> handleRaisedException(IncorrectArgException exception, WebRequest webRequest) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
