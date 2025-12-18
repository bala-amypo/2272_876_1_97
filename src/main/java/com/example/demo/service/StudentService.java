package com.example.demo.service;




import java.util.*;



import com.example.demo.entity.Student;



public interface StudentService {
  
  
  Student addData(Student stu);
  List<Student> fetchRecord();
}