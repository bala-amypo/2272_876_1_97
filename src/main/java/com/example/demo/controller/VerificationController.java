package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

   
    @PostMapping("/{verificationCode}")
    public String verifyCertificate(
            @PathVariable String verificationCode) {

        verificationService.verifyCertificate(verificationCode);
        return "Certificate verified successfully";
    }

   
    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getVerificationLogs(
            @PathVariable Long certificateId) {

        return verificationService.getLogsByCertificateId(certificateId);
    }
}
