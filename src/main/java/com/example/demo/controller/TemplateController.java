package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController{
     private final StudentService studentservice;
    public StudentController(StudentService studentservice){
        this.studentservice=studentservice;
    }

    
    @PostMapping("/add")
    public Student addTemplate(@RequestBody Student stu){
        return  studentservice.addData(stu);
    }
   @GetMapping("/fetch")
    public List<> fetchRecord(){
      return studentservice.fetchRecord();


}

}