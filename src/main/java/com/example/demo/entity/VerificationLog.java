package com.example.demo.entity;

import jakarta.persistence.*;
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

}