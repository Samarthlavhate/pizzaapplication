package com.pizza.order.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Order {
    @Id
    int orderId;
    List<Food> food;

    public Order() {
    }

    public Order(int orderId, List<Food> food) {
        this.orderId = orderId;
        this.food = food;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", food=" + food +
                '}';
    }
}
