package com.example.TASK.GlobalExceptionHandler;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionHandler {

    Logger logger = Logger.getLogger(exceptionHandler.class.getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handlegeneralexception(Exception ex){
        logger.warning("An error occurred: " + ex.getMessage());
        return ResponseEntity.status(500).body("An error occurred: " + ex.getMessage());
    }
}
