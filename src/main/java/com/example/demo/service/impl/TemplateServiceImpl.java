package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.CertificateTemplateService;

@Service
public class CertificateTemplateServiceImpl implements CertificateTemplateService {

    private final CertificateTemplateRepository repository;

    public CertificateTemplateServiceImpl(CertificateTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        return repository.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return repository.findAll();
    }

    @Override
    public CertificateTemplate findById(Long id) {
        Optional<CertificateTemplate> optional = repository.findById(id);
        return optional.orElse(null);  // return null if not found, can throw exception if preferred
    }
}
