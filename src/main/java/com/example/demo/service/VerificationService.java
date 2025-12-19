package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationLog;

public interface VerificationService {

    VerificationLog verifyCertificate(String verificationCode, String clientIp);

    List<VerificationLog> getLogsByCertificate(Long certificateId);
}
