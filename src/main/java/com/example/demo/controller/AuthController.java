package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController

public class AuthController{
    private final UserService userservice;
    public AuthController(UserService userservice){
        this.userservice=userservice;
    }

    
    @PostMapping("/register")
    public User createData(@RequestBody User use){
        return  userservice.createData(use);
    }
    @PostMapping("/login")
    public User createdData(@RequestBody User use){
        return  userservice.createdData(use);
    }

}