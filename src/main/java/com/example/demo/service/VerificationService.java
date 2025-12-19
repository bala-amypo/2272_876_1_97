package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.VerificationLog;

public interface VerificationService {

    // Verify a certificate with verification code and client IP
    VerificationLog verifyCertificate(String verificationCode, String clientIp);

    // Get all verification logs for a certificate
    List<VerificationLog> getLogsByCertificateId(Long certificateId);
}
