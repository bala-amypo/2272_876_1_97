package com.example.demo.entity;
import lombok.Builder;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Builder
public class Certificate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @ManyToOne
     @JoinColumn(name = "student_id", nullable = false)
     private Student student;
      @ManyToOne
     @JoinColumn(name = "template_id", nullable = false)
     private CertificateTemplate template;
    private LocalDate issuedDate;
     private String qrcodeUrl;
    @Column(unique = true, nullable = false, updatable = false)
     private String verificationCode;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CertificateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(CertificateTemplate template) {
        this.template = template;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

     public Certificate() {
    }

   
    public Certificate(long id, Student student, CertificateTemplate template,
                       LocalDate issuedDate, String qrcodeUrl, String verificationCode) {
        this.id = id;
        this.student = student;
        this.template = template;
        this.issuedDate = issuedDate;
        this.qrcodeUrl = qrcodeUrl;
        this.verificationCode = verificationCode;
    }

    
}

