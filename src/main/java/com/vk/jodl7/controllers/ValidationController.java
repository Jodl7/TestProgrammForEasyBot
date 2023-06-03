package com.vk.jodl7.controllers;

import com.vk.jodl7.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ValidationController {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity onMethodArgumentNotValidException() {
        return ResponseEntity.status(BAD_REQUEST).body("Fields should be fielded");
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity onNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(exception.getMessage());
    }
}
