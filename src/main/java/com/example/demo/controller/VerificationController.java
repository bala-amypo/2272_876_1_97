package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.service.VerificationService;
import com.example.demo.entity.VerificationLog;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService service;

    public VerificationController(VerificationService service) {
        this.service = service;
    }

    // ✅ PUBLIC – no authentication required
    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(
            @PathVariable String verificationCode,
            @RequestHeader("X-Forwarded-For") String clientIp) {

        return service.verifyCertificate(verificationCode, clientIp);
    }

    // 🔐 ADMIN ONLY – verification audit logs
    @GetMapping("/logs/{certificateId}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<VerificationLog> getLogsByCertificate(@PathVariable Long certificateId) {
        return service.getLogsByCertificate(certificateId);
    }
}
