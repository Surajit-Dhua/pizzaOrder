package com.pizzaOrder.app.exception;

public class NonVegPizzaValidationException extends RuntimeException {
    public NonVegPizzaValidationException(String errorMessage) {
        super(errorMessage);
    }
}
