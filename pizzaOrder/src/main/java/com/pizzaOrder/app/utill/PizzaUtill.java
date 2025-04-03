package com.pizzaOrder.app.utill;

import com.pizzaOrder.app.exception.NonVegPizzaValidationException;
import com.pizzaOrder.app.exception.NonVegToppingValidation;
import com.pizzaOrder.app.exception.VegPizzaValidationException;
import com.pizzaOrder.app.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class PizzaUtill {

    public static Pizza processVegPizza(Pizza vegPizza) {
        VegPizzaMenu vegPizzaMenu = VegPizzaMenu.getVegPizzaMenu(vegPizza.getName());
        double price = vegPizzaMenu.getPrice(vegPizza.getSize());
        //validation for non veg topping
        if(vegPizza.getToppings().stream().filter(topping->NonVegTopping.isNonVegToppingPresnt(topping)).findFirst().isPresent()){
            throw new VegPizzaValidationException("Vegetarian pizza cannot have a non-vegetarian topping.");
        }
        //calculate topping price
        price = price + calulateVegToppingsPrice(vegPizza.getToppings());
        //for large Size piza 2 topping is free
        if(vegPizza.getSize().equals("LARGE")) {
            if (vegPizza.getToppings().size() > 1) {
                double largePizaaToppingDiscount = calulateVegToppingsPrice(vegPizza.getToppings().subList(0, 1));
                price = price - largePizaaToppingDiscount;
            } else {
                price = price - calulateVegToppingsPrice(vegPizza.getToppings());
            }
        }
        vegPizza.setPrice(price);
        return vegPizza;

    }

    public static Pizza processNonVegPizza(Pizza nonVegPizza){
        NonVegPizzaMenu nonVegPizzaMenu = NonVegPizzaMenu.getNonVegPizzaMenu(nonVegPizza.getName());
        double price = nonVegPizzaMenu.getPrice(nonVegPizza.getSize());
        //validation
        if(nonVegPizza.getToppings().contains("Paneer")) {
            throw new NonVegPizzaValidationException("Non-vegetarian pizza cannot have paneer topping.");
        }
        //topping validation
        if(nonVegPizza.getToppings().stream().filter(topping->NonVegTopping.isNonVegToppingPresnt(topping)).count()>1) {
            throw new NonVegToppingValidation("You can add only one of the non-veg toppings in non-vegetarian pizza.");
        }
        //calculate toppping price
        price = price + calulateNonVegToppingsPrice(nonVegPizza.getToppings());
        //for large Size piza 2 topping is free
        if(nonVegPizza.getSize().equals("LARGE")) {
            if (nonVegPizza.getToppings().size() > 1) {
                double largePizaaToppingDiscount = calulateNonVegToppingsPrice(nonVegPizza.getToppings().subList(0, 1));
                price = price - largePizaaToppingDiscount;
            } else {
                price = price - calulateNonVegToppingsPrice(nonVegPizza.getToppings());
            }
        }
        nonVegPizza.setPrice(price);
        return nonVegPizza;
    }

    private static double calulateNonVegToppingsPrice(List<String> topping){
        AtomicInteger price = new AtomicInteger(0);
        topping.stream().forEach(top->price.addAndGet((int) getNonVegToppingPrice(top)));
        topping.stream().forEach(top->price.addAndGet((int) getVegToppingPrice(top)));
        return price.doubleValue();
    }
    private static double calulateVegToppingsPrice(List<String> topping){
        AtomicInteger price = new AtomicInteger(0);
        topping.stream().forEach(top->price.addAndGet((int) getVegToppingPrice(top)));
        return price.doubleValue();
    }
    private static double getVegToppingPrice(String top){
        VegTopping vegTopping = VegTopping.getVegTopping(top);
        if(Objects.nonNull(vegTopping)){
            return vegTopping.getPrice();
        }
        return 0;
    }

    private static double getNonVegToppingPrice(String top){
        NonVegTopping nonVegTopping = NonVegTopping.getVegTopping(top);
        if(Objects.nonNull(nonVegTopping)){
            return nonVegTopping.getPrice();
        }
        return 0;
    }
}
