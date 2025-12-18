package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/students")
public class StudentController{
    private final StudentService studentservice;
    public StudentController(StudeService studentservice){
        this.studentservice=studentservice;
    }

    
    @PostMapping("/add")
    public Student createData(@RequestBody Student stu){
        return  userservice.createData(stu);
    }
    @GetMapping("/addalldata")
    public Student getData(@RequestBody User user){
        return  userservice.logData(use);
    }

}