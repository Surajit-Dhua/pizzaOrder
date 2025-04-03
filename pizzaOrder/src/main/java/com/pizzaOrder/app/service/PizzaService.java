package com.pizzaOrder.app.service;

import com.pizzaOrder.app.model.Order;
import com.pizzaOrder.app.model.Pizza;
import com.pizzaOrder.app.model.Side;
import com.pizzaOrder.app.utill.PizzaUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PizzaService {

    @Autowired
    PizzaFactory pizzaFactory;
    public void placeOrder(Order order) {
        order.getPizzas().stream().forEach(pizza -> pizzaFactory.createPizza(pizza));
        //set total price for pizza
        order.setTotalAmount(order.getPizzas().stream().mapToDouble(Pizza::getPrice).sum());
        //update price for Side
        AtomicInteger sidePrice = new AtomicInteger(0);
        order.getSides().forEach(side->sidePrice.addAndGet((side == Side.COLD_DRINK ? 55 : 90)));
        order.setTotalAmount(order.getTotalAmount()+sidePrice.doubleValue());
    }
}
