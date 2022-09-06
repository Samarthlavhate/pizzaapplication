package com.pizza.order.controller;

import com.pizza.order.domain.Food;
import com.pizza.order.domain.Order;
import com.pizza.order.domain.User;
import com.pizza.order.exception.UserAlreadyExsist;
import com.pizza.order.exception.UserNotFound;
import com.pizza.order.orderservice.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/samar-api-v2")
public class PizzaController {

    @Autowired
    OrderServiceImpl orderService;
    ResponseEntity responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {


        try {
            responseEntity =  new ResponseEntity<>(orderService.registerUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExsist e) {
            throw new RuntimeException(e);
        }


        return responseEntity;
    }

    @PostMapping("/user/{userName}/food")
    public ResponseEntity<?> saveOrderToList( @PathVariable String userName,@RequestBody Food food ) throws UserNotFound {
            responseEntity = new ResponseEntity<>(orderService.saveOrder(food, userName), HttpStatus.ACCEPTED);
            return responseEntity;
    }
    @GetMapping("/user/{userName}/orders")
    public ResponseEntity<?> getAllFood(@PathVariable String userName) throws UserNotFound {

            responseEntity = new ResponseEntity<>(orderService.getAllFood(userName), HttpStatus.OK);
            return responseEntity;
    }
    @DeleteMapping("/user/{foodName}/{userName}")
    public ResponseEntity<?> deleteOrder(@PathVariable String foodName ,@PathVariable String userName) throws UserNotFound {

        responseEntity = new ResponseEntity<>(orderService.deleteFoodFromList(foodName,userName), HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()  {

        responseEntity = new ResponseEntity<>(orderService.getAllUSe(), HttpStatus.OK);
        return responseEntity;
    }


}
