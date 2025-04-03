package com.pizzaOrder.app.exception;

public class VegPizzaValidationException extends RuntimeException {
    public VegPizzaValidationException(String errorMessage) {
        super(errorMessage);
    }
}
