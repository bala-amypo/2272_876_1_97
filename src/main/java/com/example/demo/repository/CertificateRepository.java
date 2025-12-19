package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Certificate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CertificateRepository
        extends JpaRepository<Certificate, Long> {

    // Used by VerificationService
    Optional<Certificate> findByVerificationCode(String verificationCode);

    // Used by CertificateServiceImpl
    Optional<Certificate> findByCode(String code);

    List<Certificate> findByStudentId(Long studentId);
}
