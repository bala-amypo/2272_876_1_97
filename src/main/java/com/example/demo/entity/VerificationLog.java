package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "certificate_id", nullable = false)
    private Certificate certificate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime verifiedAt;

    @Column(nullable = false)
    private String ipAddress;
    
    public VerificationLog() {}
    
    public VerificationLog(Certificate certificate, String status, LocalDateTime verifiedAt, String ipAddress) {
        this.certificate = certificate;
        this.status = status;
        this.verifiedAt = verifiedAt;
        this.ipAddress = ipAddress;
    }
    
    public static VerificationLogBuilder builder() {
        return new VerificationLogBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Certificate getCertificate() { return certificate; }
    public void setCertificate(Certificate certificate) { this.certificate = certificate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    
    public static class VerificationLogBuilder {
        private Long id;
        private Certificate certificate;
        private String status;
        private LocalDateTime verifiedAt;
        private String ipAddress;
        
        public VerificationLogBuilder id(Long id) { this.id = id; return this; }
        public VerificationLogBuilder certificate(Certificate certificate) { this.certificate = certificate; return this; }
        public VerificationLogBuilder status(String status) { this.status = status; return this; }
        public VerificationLogBuilder verifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; return this; }
        public VerificationLogBuilder ipAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }
        
        public VerificationLog build() {
            VerificationLog log = new VerificationLog();
            log.id = this.id;
            log.certificate = this.certificate;
            log.status = this.status;
            log.verifiedAt = this.verifiedAt;
            log.ipAddress = this.ipAddress;
            return log;
        }
    }
}
