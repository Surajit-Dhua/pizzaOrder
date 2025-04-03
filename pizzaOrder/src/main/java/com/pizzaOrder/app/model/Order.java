package com.pizzaOrder.app.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    private int orderId;
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();
    private double totalAmount;

    public double getTotalAmount() {
        return totalAmount;
    }

}
