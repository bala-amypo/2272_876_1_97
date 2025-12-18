package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController

public class StudentController{
    private final StudentService studentservice;
    public StudentController(StudeService studentservice){
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