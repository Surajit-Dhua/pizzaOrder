package com.pizzaOrder.app.model;

import com.pizzaOrder.app.model.CrustType;
import com.pizzaOrder.app.model.PizzaSize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Pizza {

    private String name;
    private String type;
    private PizzaSize size;
    private CrustType crust;
    private List<String> toppings = new ArrayList<>();
    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    public Pizza(String name, PizzaSize size, CrustType crust) {
        this.name = name;
        this.size = size;
        this.crust = crust;
    }

    public double getPrice() {
        return price;
    }


}
