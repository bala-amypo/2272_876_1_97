package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
@Builder
public class CertificateTemplate{
    @id
    private long id;
    @Column(unique=true)
    private String templateName;
    private String backgroundUrl;
    
}