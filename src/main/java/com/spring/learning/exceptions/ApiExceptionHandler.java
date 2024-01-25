package com.spring.learning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(final ApiRequestException e) {
        final ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(final NotFoundException e) {
        final ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
