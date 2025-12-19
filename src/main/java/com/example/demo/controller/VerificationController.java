package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(
            @PathVariable String verificationCode,
            HttpServletRequest request) {

        String clientIp = request.getRemoteAddr();
        return verificationService.verifyCertificate(verificationCode, clientIp);
    }

    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getLogsByCertificate(
            @PathVariable Long certificateId) {
        return verificationService.getLogsByCertificate(certificateId);
    }
}
