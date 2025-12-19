package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService service;

    public VerificationController(VerificationService service) {
        this.service = service;
    }

    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(
            @PathVariable String verificationCode,
            @RequestHeader(value = "X-Forwarded-For", required = false) String clientIp) {

        if (clientIp == null || clientIp.isBlank()) {
            clientIp = "UNKNOWN";
        }

        return service.verifyCertificate(verificationCode, clientIp);
    }

    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getLogsByCertificate(@PathVariable Long certificateId) {
        return service.getLogsByCertificate(certificateId);
    }
}
