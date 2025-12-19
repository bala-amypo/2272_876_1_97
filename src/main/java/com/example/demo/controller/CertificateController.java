package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(
            @PathVariable Long studentId,
            @PathVariable Long templateId) {
        return service.generateCertificate(studentId, templateId);
    }

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return service.getCertificate(id);
    }

    @GetMapping("/verify/{code}")
    public Certificate findByVerificationCode(@PathVariable String code) {
        return service.findByVerificationCode(code);
    }

    @GetMapping("/student/{studentId}")
    public List<Certificate> findByStudentId(@PathVariable Long studentId) {
        return service.findByStudentId(studentId);
    }
}
