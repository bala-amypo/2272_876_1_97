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
    public Student addStudent(@RequestBody Student stu){
        return  studentservice.addStudents(stu);
    }
   @GetMapping("/fetch")
    public List<Student> getAllStudents(){
      return studentservice.getAllStudents();


}

}