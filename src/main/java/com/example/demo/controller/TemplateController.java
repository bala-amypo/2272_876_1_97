package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.CertificateTemplateService;

@RestController
@RequestMapping("/templates")
public class CertificateTemplateController {

    private final CertificateTemplateService service;

    public CertificateTemplateController(CertificateTemplateService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public CertificateTemplate addTemplate(@RequestBody CertificateTemplate template) {
        return service.addTemplate(template);
    }

    @GetMapping("/all")
    public List<CertificateTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }

    @GetMapping("/{id}")
    public CertificateTemplate getTemplateById(@PathVariable Long id) {
        return service.findById(id);
    }
}
