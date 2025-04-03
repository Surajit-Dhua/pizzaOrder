package com.pizzaOrder.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(VegPizzaValidationException.class)
    public ResponseEntity<String> handleVegPizzaValidationException(VegPizzaValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NonVegToppingValidation.class)
    public ResponseEntity<String> handleNonVegToppingValidation(NonVegToppingValidation ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NonVegPizzaValidationException.class)
    public ResponseEntity<String> handleNonVegToppingValidation(NonVegPizzaValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
