package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final CertificateTemplateRepository repository;

    public TemplateServiceImpl(CertificateTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        repository.findByTemplateName(template.getTemplateName()).ifPresent(t -> {
            throw new RuntimeException("Template name exists");
        });
        if (template.getBackgroundUrl() == null || template.getBackgroundUrl().isBlank()) {
            throw new RuntimeException("Background URL cannot be blank");
        }
        return repository.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return repository.findAll();
    }

    @Override
    public CertificateTemplate findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));
    }
}
