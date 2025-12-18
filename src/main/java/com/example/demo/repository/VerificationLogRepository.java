package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VerificationLog;

@Repository
public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {

    List<VerificationLog> findByCertificateId(Long certificateId);

    VerificationLog findByVerificationCode(String verificationCode);
}
