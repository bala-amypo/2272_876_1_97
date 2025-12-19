package com.example.demo.service;




import java.util.*;



import com.example.demo.entity.Student;



public interface StudentService {
  
  
  Student addStudents(Student stu);
  List<Student> getAllStudents();
}