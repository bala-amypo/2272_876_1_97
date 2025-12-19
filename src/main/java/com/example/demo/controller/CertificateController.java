package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;
import java.util.Optional;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(@PathVariable Long studentId,
                                           @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    @GetMapping("/{verificationCode}")
    public Optional<Certificate> getCertificate(@PathVariable String verificationCode) {
        return certificateService.getCertificateByVerificationCode(verificationCode);
    }
}
