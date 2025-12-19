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

    // Generate a certificate
    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(
            @PathVariable Long studentId,
            @PathVariable Long templateId) {
        return service.generateCertificate(studentId, templateId);
    }

    // Get certificate by ID
    @GetMapping("/{certificateId}")
    public Certificate getCertificate(@PathVariable Long certificateId) {
        return service.getCertificate(certificateId);
    }

    // Get certificate by verification code
    @GetMapping("/verify/code/{verificationCode}")
    public Certificate getCertificateByVerificationCode(
            @PathVariable String verificationCode) {
        return service.findByVerificationCode(verificationCode);
    }

    // Get all certificates of a student
    @GetMapping("/student/{studentId}")
    public List<Certificate> getCertificatesByStudent(
            @PathVariable Long studentId) {
        return service.findByStudentId(studentId);
    }
}
