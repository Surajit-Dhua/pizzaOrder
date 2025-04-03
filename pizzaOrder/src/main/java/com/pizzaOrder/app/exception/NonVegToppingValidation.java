package com.pizzaOrder.app.exception;

public class NonVegToppingValidation extends RuntimeException{

    public NonVegToppingValidation(String errorMessage) {
        super(errorMessage);
    }
}
