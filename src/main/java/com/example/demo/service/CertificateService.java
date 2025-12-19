package com.example.demo.service;

import com.example.demo.entity.Certificate;
import java.util.Optional;

public interface CertificateService {
    Certificate generateCertificate(Long studentId, Long templateId);
    Optional<Certificate> getCertificateByVerificationCode(String code);
}
