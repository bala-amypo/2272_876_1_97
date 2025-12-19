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

        if (template.getTemplateName() == null || template.getBackgroundUrl() == null) {
            throw new RuntimeException("Template fields cannot be null");
        }

        repository.findByTemplateName(template.getTemplateName()).ifPresent(t -> {
            throw new RuntimeException("Template name exists");
        });

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
