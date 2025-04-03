package com.pizzaOrder.app.service;

import com.pizzaOrder.app.model.Pizza;
import com.pizzaOrder.app.utill.PizzaUtill;
import org.springframework.stereotype.Component;


import static com.pizzaOrder.app.utill.PizzaUtill.processNonVegPizza;

@Component
public class PizzaFactory {
    public Pizza createPizza(Pizza pizza) {
        if (pizza.getType().equalsIgnoreCase("VEG")) {
            return PizzaUtill.processVegPizza(pizza);
        } else if (pizza.getType().equalsIgnoreCase("NON_VEG")) {
            return processNonVegPizza(pizza);
        }
        throw new IllegalArgumentException("Invalid pizza type");
    }
}
