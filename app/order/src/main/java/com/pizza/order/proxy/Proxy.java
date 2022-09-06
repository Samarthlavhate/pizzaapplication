package com.pizza.order.proxy;

import com.pizza.order.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "security-service",url="localhost:9093")
public interface Proxy  {
    @PostMapping("/samar-api/register")
    public ResponseEntity saveUser(@RequestBody User user);
}
