package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> notFoundException(
            UserNotFoundException userNotFoundException
    ) {
        ApiException exception = new ApiException()
                .setMessage(userNotFoundException.getMessage())
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .setZonedDateTime(ZonedDateTime.now());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
