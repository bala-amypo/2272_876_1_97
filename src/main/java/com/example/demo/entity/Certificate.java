package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
@Builder
public class Certificate{
     private int id;
     @ManyToOne
     
    @JoinColumn(name = "student_id", nullable = false)
    private Visitor visitor;
     private String qrcodeUrl;
     @Column(unique=true)
     private String verificationCode;

}