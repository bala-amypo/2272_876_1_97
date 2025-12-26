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

    // ✅ Only ADMIN can generate certificates
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generate(@PathVariable Long studentId,
                                @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    // ✅ ADMIN and STAFF can view certificate by ID
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping("/{certificateId}")
    public Certificate get(@PathVariable Long certificateId) {
        return certificateService.getCertificate(certificateId);
    }

    // ✅ Public verification (no auth required)
    @PreAuthorize("permitAll()")
    @GetMapping("/verify/code/{verificationCode}")
    public Certificate getCertificateByCode(@PathVariable String verificationCode) {
        return certificateService.findByVerificationCode(verificationCode);
    }

    // ✅ ADMIN and STAFF can view student certificates
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping("/student/{studentId}")
    public List<Certificate> getCertificatesByStudent(@PathVariable Long studentId) {
        return certificateService.findByStudentId(studentId);
    }
}
