package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;

@RestController
@RequestMapping("/verification")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/verify")
    public VerificationLog verifyCertificate(
            @RequestParam String verificationCode,
            @RequestParam String clientIp) {

        return verificationService.verifyCertificate(verificationCode, clientIp);
    }

    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getLogsByCertificate(@PathVariable Long certificateId) {
        return verificationService.getLogsByCertificateId(certificateId);
    }
}
