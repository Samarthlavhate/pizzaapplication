package com.example.security.usercontroller;

import com.example.security.exception.UserNotFound;
import com.example.security.model.User;
import com.example.security.service.SecurityTokenGenerator;
import com.example.security.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/samar-api")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;
    ResponseEntity responseEntity;

     @Autowired

    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user) {

        User createdUser = userService.saveUser(user);
        return responseEntity = new ResponseEntity("User Created" , HttpStatus.CREATED);
    }
    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "fallbackLogin",commandKey = "loginUser",groupKey = "login")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFound, UserNotFound {

        Map<String, String> map = null;
        try {
            User userObj = userService.findByUsernameAndPassword(user.getUserName(), user.getPassword());
            if (userObj.getUserName().equals(user.getUserName())) {
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        }
        catch(UserNotFound e){
            throw new UserNotFound();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    public ResponseEntity fallbackLogin(@RequestBody User user) throws UserNotFound, UserNotFound{
         String msg ="server timeout";
         return new ResponseEntity(msg, HttpStatus.GATEWAY_TIMEOUT);
    }
}
