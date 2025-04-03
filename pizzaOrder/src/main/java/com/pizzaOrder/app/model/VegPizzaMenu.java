package com.pizzaOrder.app.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum VegPizzaMenu {
    DELUXE_VEGGIE("Deluxe Veggie", 150, 200, 325),
    CHEESE_AND_CORN("Cheese and corn", 175, 375, 475),
    PANEER_TIKKA(" Paneer Tikka", 160, 290, 340);
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
  public static VegPizzaMenu getVegPizzaMenu(String codeDesc){
        return Arrays.stream(VegPizzaMenu.values()).filter(p->p.codeDesc.equals(codeDesc)).findAny().orElse(null);
  }

}
