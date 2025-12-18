// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import lombok.Builder;

// @Entity
// @Builder
// public class VerificationLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;

//     @ManyToOne(optional = false)
//     @JoinColumn(name = "certificate_id", nullable = false)
//     private Certificate certificate;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime verifiedAt;

//     @Column(nullable = false)
//     private String status; 

//     private String ipAddress;

    
//     public VerificationLog() {
//     }

    
//     public VerificationLog(Certificate certificate, String status, String ipAddress) {
//         this.certificate = certificate;
//         this.status = status;
//         this.ipAddress = ipAddress;
//     }

    
//     @PrePersist
//     private void onVerify() {
//         this.verifiedAt = LocalDateTime.now();
//         if (status != null) {
//             this.status = status.toUpperCase();
//         }
//     }

   
//     public long getId() {
//         return id;
//     }

//     public void setId(long id) {
//         this.id = id;
//     }

//     public Certificate getCertificate() {
//         return certificate;
//     }

//     public void setCertificate(Certificate certificate) {
//         this.certificate = certificate;
//     }

//     public LocalDateTime getVerifiedAt() {
//         return verifiedAt;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         if (!"SUCCESS".equalsIgnoreCase(status) && !"FAILED".equalsIgnoreCase(status)) {
//             throw new IllegalArgumentException("Status must be SUCCESS or FAILED");
//         }
//         this.status = status.toUpperCase();
//     }

//     public String getIpAddress() {
//         return ipAddress;
//     }

//     public void setIpAddress(String ipAddress) {
//         this.ipAddress = ipAddress;
//     }
// }
