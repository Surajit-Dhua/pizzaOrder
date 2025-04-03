package com.pizzaOrder.app.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum NonVegPizzaMenu {
    NON_VEG_SUPREME("Non-Veg Supreme", 190, 325, 425),
    CHICKEN_TIKKA("Chicken Tikka", 210, 370, 500),
    PEPPER_BARBECUE_CHICKEN("Pepper Barbecue Chicken", 220, 380, 525);

    private final String codeDesc;
    private final double regularPrice;
    private final double mediumPrice;
    private final double largePrice;
    public double getPrice(PizzaSize size) {
        return switch (size) {
            case REGULAR -> regularPrice;
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
        };
    }

    public static NonVegPizzaMenu getNonVegPizzaMenu(String codeDesc){
        return Arrays.stream(NonVegPizzaMenu.values()).filter(p->p.codeDesc.equals(codeDesc)).findAny().orElse(null);
    }
}
