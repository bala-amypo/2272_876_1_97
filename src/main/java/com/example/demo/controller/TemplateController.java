package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

@RestController
@RequestMapping("/templates")
public class CertificateTemplateController {

    private final TemplateService templateService;

    /
    public CertificateTemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("/addtemplate")
    public CertificateTemplate addTemplate(
            @RequestBody CertificateTemplate temp) {
        return templateService.addTemplate(temp);
    }

    @GetMapping("/fetchtemplate")
    public List<CertificateTemplate> fetchTemplate() {
        return templateService.fetchTemplate();
    }
}
