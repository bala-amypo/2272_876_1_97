package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Certificate;
import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    // Wrong: findByCode
    // Optional<Certificate> findByCode(String code);

    // Correct: matches the field name in Certificate entity
    Optional<Certificate> findByVerificationCode(String verificationCode);
}
