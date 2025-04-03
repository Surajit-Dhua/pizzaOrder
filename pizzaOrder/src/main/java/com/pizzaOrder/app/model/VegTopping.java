package com.pizzaOrder.app.model;


import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum VegTopping {
    BLACK_OLIVE("Black olive", 20),
    CAPSICUM("Capsicum", 25),
    PANEER("Paneer", 35), MUSHROOM("Mushroom",30),
    TOMATO("Fresh tomato", 10),
    EXTRA_CHEESE("Extra cheese", 35);

    private final String codeDesc;
    private final double price;

    public static VegTopping getVegTopping(String codeDesc){
        return Arrays.stream(VegTopping.values()).filter(p->p.codeDesc.equals(codeDesc)).findAny().orElse(null);
    }

    public double getPrice() {
        return price;
    }
    public static boolean isVegToppingPresnt(String codeDesc) {
        return Arrays.stream(VegTopping.values()).filter(p->p.codeDesc.equals(codeDesc)).findFirst().isPresent();
    }
}
