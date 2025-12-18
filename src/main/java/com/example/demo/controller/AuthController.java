package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController

public class AuthController{
    private final UserService userservice;
    public AuthController(UserService userservice){
        this.userservice=userservice;
    }

    
    @PostMapping("/register")
    public User createData(@RequestBody User user){
        return  userservice.createData(use);
    }
    @PostMapping("/login")
    public User createdData(@RequestBody User user){
        return  userservice.logData(use);
    }

}