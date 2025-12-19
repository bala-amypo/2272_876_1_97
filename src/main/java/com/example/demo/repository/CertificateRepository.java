package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


import com.example.demo.entity.Certificate;
@Repository

public interface CertificateRepository extends JpaRepository<Certificate,Long>{
     Optional<Certificate> findByVerificationCode(String verificationCode);

}
 