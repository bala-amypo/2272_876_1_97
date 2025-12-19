package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Certificate;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.service.CertificateService;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate addCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificateByCode(String code) {
        return certificateRepository
                .findByCode(code)
                .orElseThrow(() ->
                        new RuntimeException("Certificate not found with code: " + code));
    }

    @Override
    public List<Certificate> getCertificatesByStudentId(Long studentId) {
        return certificateRepository.findByStudentId(studentId);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
