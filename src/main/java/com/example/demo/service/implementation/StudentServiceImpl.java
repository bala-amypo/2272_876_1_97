package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudents(Student stu) {
        return repository.save(stu); 
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
