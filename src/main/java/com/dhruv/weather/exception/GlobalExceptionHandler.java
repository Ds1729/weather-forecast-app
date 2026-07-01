package com.dhruv.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientError(HttpClientErrorException ex) {

        ErrorResponse error = new ErrorResponse();

        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
            error.setMessage("City not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        error.setMessage("Something went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}