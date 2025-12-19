package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;
import java.util.*;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final CertificateTemplateRepository repository;

    public TemplateServiceImpl(CertificateTemplateRepository repository) {
        this.repository = repository;
    }

    public CertificateTemplate getTemplate(CertificateTemplate temp) {
        return repository.save(temp); 
    }

    public List<CertificateTemplate> getAllTemplates() {
        return repository.findAll();
    }
}
