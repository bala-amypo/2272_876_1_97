package com.example.demo.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationService;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationLogRepository verificationLogRepository;

    public VerificationServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    @Override
    public void verifyCertificate(String verificationCode) {

        VerificationLog log = verificationLogRepository.findByVerificationCode(verificationCode);

        if (log == null) {
            throw new RuntimeException("Invalid verification code");
        }

        log.setVerifiedAt(LocalDateTime.now());
        verificationLogRepository.save(log);
    }

    @Override
    public List<VerificationLog> getLogsByCertificateId(Long certificateId) {
        return verificationLogRepository.findByCertificateId(certificateId);
    }
}
