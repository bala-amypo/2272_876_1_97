// package com.example.demo.controller;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;

// @RestController

// public class AuthController{
//     private final UserService userservice;
//     public AuthController(UserService userservice){
//         this.userservice=userservice;
//     }

    
//     @PostMapping("/register")
//     public User register(@RequestBody User user){
//         return  userservice.regidter(use);
//     }
//     @PostMapping("/login")
//     public User findByEmail(@RequestBody User user){
//         return  userservice.findByEmail(use);
//     }

// }