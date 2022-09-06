package com.pizza.order.orderservice;

import com.pizza.order.domain.Food;
import com.pizza.order.domain.Order;
import com.pizza.order.domain.User;
import com.pizza.order.exception.UserAlreadyExsist;
import com.pizza.order.exception.UserNotFound;
import com.pizza.order.proxy.Proxy;
import com.pizza.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderServiceI{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    Proxy proxy;

    @Override
    public User registerUser(User user) throws UserAlreadyExsist {
        if(orderRepository.findById(user.getEmail()).isPresent()){
           throw new UserAlreadyExsist();
        }
        proxy.saveUser(user);
        return  orderRepository.save(user);
//niit pdf file
// with real life example
    }

    @Override
    public User saveOrder(Food food , String userName) throws UserNotFound {
            if (orderRepository.findById(userName).isEmpty()) {
                throw new UserNotFound();
            }
            User user = orderRepository.findById(userName).get();
            Random random = new Random();
            if (user.getOrder() == null) {
                Order order = new Order();
                order.setOrderId(random.nextInt(1000));
                List<Food> foods = new ArrayList<>();
                foods.add(food);
                order.setFood(foods);
                user.setOrder(order);
            }
            else {
                Order order=user.getOrder();
                List<Food> f= order.getFood();
                f.add(food);
                order.setFood(f);}
                return orderRepository.save(user);

    }

    @Override
    public User deleteFoodFromList(String foodName ,String userName) throws UserNotFound {
       if(orderRepository.findById(userName).isPresent()) {
           User user = orderRepository.findById(userName).get();
           Order order = user.getOrder();
           List<Food> food = order.getFood();
           List<Food> foods = food.stream().filter(f -> !f.getFoodName().equals(foodName)).toList();
           order.setFood(foods);
           user.setOrder(order);
           return orderRepository.save(user);


       }else {
       throw new UserNotFound();
       }

    }

    @Override
    public Order getAllFood(String userName) throws UserNotFound {
        if(orderRepository.findById(userName).isPresent()){
        User user2= orderRepository.findById(userName).get();
        return user2.getOrder();

        }
        throw new UserNotFound();
    }

    @Override
    public List<User> getAllUSe() {
     return orderRepository.findAll();
    }
}
