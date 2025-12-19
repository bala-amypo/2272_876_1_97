package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
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
    public VerificationLog verifyCertificate(@PathVariable String verificationCode,HttpServletRequest request) {

        String clientIp = request.getRemoteAddr();
        return verificationService.verifyCertificate(verificationCode, clientIp);
    }

   
    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getVerificationLogs(@PathVariable Long certificateId) {

        return verificationService.getLogsByCertificate(certificateId);
    }
}
