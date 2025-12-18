package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Builder
public class VerificationLog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
     @JoinColumn(name = "certificate_id", nullable = false)
     private Certificate certificate;
    private LocalDateTime verifiedAt;
    private String status;
    private String ipAddress;
     
    public VerificationLog() {
    }

    public VerificationLog(Certificate certificate, String status, String ipAddress) {
        this.certificate = certificate;
        this.status = status;
        this.ipAddress = ipAddress;
    }

    
    @PrePersist
    private void onVerify() {
        this.verifiedAt = LocalDateTime.now();

      
        if (status != null) {
            this.status = status.toUpperCase();
        }
    }

   
    public long getId() {
        return id;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public String getStatus() {
        return status;
    }

  
    public void setStatus(String status) {
        if (!"SUCCESS".equalsIgnoreCase(status) && !"FAILED".equalsIgnoreCase(status)) {
            throw new IllegalArgumentException("Status must be SUCCESS or FAILED");
        }
        this.status = status.toUpperCase();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}