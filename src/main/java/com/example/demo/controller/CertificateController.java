package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;
import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    // 🔐 ADMIN ONLY
    @PostMapping("/generate/{studentId}/{templateId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Certificate generate(@PathVariable Long studentId,
                                @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    // 🔐 ADMIN or STAFF
    @GetMapping("/{certificateId}")
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    public Certificate get(@PathVariable Long certificateId) {
        return certificateService.getCertificate(certificateId);
    }

    // 🌍 PUBLIC (NO AUTH REQUIRED)
    @GetMapping("/verify/code/{verificationCode}")
    public Certificate getCertificateByCode(@PathVariable String verificationCode) {
        return certificateService.findByVerificationCode(verificationCode);
    }

    // 🔐 ADMIN or STAFF
    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    public List<Certificate> getCertificatesByStudent(@PathVariable Long studentId) {
        return certificateService.findByStudentId(studentId);
    }
}
