package com.pizzaOrder.app.controller;


import com.pizzaOrder.app.model.Order;
import com.pizzaOrder.app.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/order")
    public String placeOrder(@RequestBody Order order) {
         pizzaService.placeOrder(order);
        return "Order placed successfully! and You need to pay:" + order.getTotalAmount();
    }

}
