package com.pizza.order.orderservice;

import com.pizza.order.domain.Food;
import com.pizza.order.domain.Order;
import com.pizza.order.domain.User;
import com.pizza.order.exception.UserAlreadyExsist;
import com.pizza.order.exception.UserNotFound;

import java.util.List;

public interface OrderServiceI {
    User registerUser(User user) throws UserAlreadyExsist;
    User saveOrder(Food food , String userName) throws UserNotFound;
    User deleteFoodFromList(String foodName, String userName) throws UserNotFound;
    Order getAllFood(String userName) throws UserNotFound;
    List<User> getAllUSe();

}
