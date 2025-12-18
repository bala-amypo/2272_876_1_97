package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public User createData(User user) {
        return repository.save(user); 
    }

    public User logData(User user) {
        return repository.save(user);
    }
}
