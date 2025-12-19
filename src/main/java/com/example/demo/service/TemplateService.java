package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CertificateTemplate;

public interface CertificateTemplateService {
    
    CertificateTemplate addTemplate(CertificateTemplate template);

    List<CertificateTemplate> getAllTemplates();

    CertificateTemplate findById(Long id);
}
