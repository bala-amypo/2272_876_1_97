package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.VerificationLog;

public interface VerificationService {

    void verifyCertificate(String verificationCode);

    List<VerificationLog> getLogsByCertificateId(Long certificateId);
}
