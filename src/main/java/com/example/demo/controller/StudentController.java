package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

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
   @GetMapping("/fetch")
    public List<Student> fetchRecord(){
        return userservice.fetchRecord();
    }

}