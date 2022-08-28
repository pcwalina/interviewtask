package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvisor {

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<CustomErrorMessage> handleUserDoesNotExistException(UserDoesNotExistException e) {
        return new ResponseEntity<>(new CustomErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<CustomErrorMessage> wrongHeaderException(HttpMediaTypeException e) {
        return new ResponseEntity<>(new CustomErrorMessage(e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value()), HttpStatus.NOT_ACCEPTABLE);
    }


}
