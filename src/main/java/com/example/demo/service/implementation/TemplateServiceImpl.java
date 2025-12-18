package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.TemplateService;

@Service
public class StudentServiceImpl implements StudentService {

    private final CertificateTemplateRepository repository;

    public StudentServiceImpl(CertificateTemplateRepository repository) {
        this.repository = repository;
    }

    public Student addData(Student stu) {
        return repository.save(stu); 
    }

    public List<Student> fetchRecord() {
        return repository.findAll();
    }
}
