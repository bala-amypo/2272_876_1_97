package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

   
    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(
            @PathVariable Long studentId,
            @PathVariable Long templateId) {

        return certificateService.generateCertificate(studentId, templateId);
    }

 
    @GetMapping("/{certificateId}")
    public Certificate getCertificate(
            @PathVariable Long certificateId) {

        return certificateService.getCertificateById(certificateId);
    }
`
    
    @GetMapping("/verify/code/{verificationCode}")
    public Certificate getCertificateByCode(
            @PathVariable String verificationCode) {

        return certificateService.findByVerificationCode(verificationCode);
    }
}
