package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Certificate;

public interface CertificateService {

    Certificate addCertificate(Certificate certificate);

    Certificate getCertificateByCode(String code);

    List<Certificate> getCertificatesByStudentId(Long studentId);

    List<Certificate> getAllCertificates();

    void deleteCertificate(Long id);
}
