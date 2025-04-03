package com.pizzaOrder.app.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PizzaSize {
    REGULAR("Regular"), MEDIUM("Medium"), LARGE("Large");

    public final String codeDesc;

    public String getCodeDesc() {
        return codeDesc;
    }
}
