package com.pizzaOrder.app.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum NonVegTopping {
    CHICKEN_TIKKA("Chicken tikka", 35),
    BARBEQUE_CHICKEN("Barbeque chicken", 45),
    GRILLED_CHICKEN("Grilled chicken", 40);

    private final String codeDesc;
    private final double price;

    public static NonVegTopping getVegTopping(String codeDesc){
        return Arrays.stream(NonVegTopping.values()).filter(p->p.codeDesc.equals(codeDesc)).findFirst().orElse(null);
    }

    public double getPrice() {
        return price;
    }
    public static boolean isNonVegToppingPresnt(String codeDesc) {
        return Arrays.stream(NonVegTopping.values()).filter(p->p.codeDesc.equals(codeDesc)).findFirst().isPresent();
    }
}
