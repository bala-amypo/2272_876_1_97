package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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

    // Anyone can verify a certificate (public endpoint)
    @PreAuthorize("permitAll()")
    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(@PathVariable String verificationCode,
                                             @RequestHeader("X-Forwarded-For") String clientIp) {
        return service.verifyCertificate(verificationCode, clientIp);
    }

    // Only ADMIN or STAFF can view verification logs
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getLogsByCertificate(@PathVariable Long certificateId) {
        return service.getLogsByCertificate(certificateId);
    }
}
