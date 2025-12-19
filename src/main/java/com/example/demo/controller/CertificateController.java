package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(@PathVariable Long studentId,
                                           @PathVariable Long templateId) {
        return service.generateCertificate(studentId, templateId);
    }

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return service.getCertificate(id);
    }

    @GetMapping("/verify/code/{verificationCode}")
    public Certificate findByVerificationCode(@PathVariable String verificationCode) {
        return service.findByVerificationCode(verificationCode);
    }

    @GetMapping("/student/{studentId}")
    public List<Certificate> findByStudentId(@PathVariable Long studentId) {
        return service.findByStudentId(studentId);
    }
}
