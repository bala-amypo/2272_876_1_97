package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private final TemplateService service;

    public TemplateController(TemplateService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Only admins can add templates
    public CertificateTemplate add(@RequestBody CertificateTemplate template) {
        return service.addTemplate(template);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')") // Admin and staff can view templates
    public List<CertificateTemplate> list() {
        return service.getAllTemplates();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')") // Admin and staff can get template by ID
    public CertificateTemplate getTemplateById(@PathVariable Long id) {
        return service.findById(id);
    }
}