package com.example.security.service;

import com.example.security.exception.UserNotFound;
import com.example.security.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public User findByUsernameAndPassword(String username , String password) throws UserNotFound;

}
