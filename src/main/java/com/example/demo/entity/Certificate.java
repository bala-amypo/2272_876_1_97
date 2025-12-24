package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    @Column(name = "verification_code", unique = true, nullable = false)
    private String verificationCode;

    @Column(name = "issued_date")
    private LocalDate issuedDate;

    @Column(name = "qr_code_url", columnDefinition = "TEXT")
    private String qrCodeUrl;

    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VerificationLog> verificationLogs;
    
    public Certificate() {}
    
    public Certificate(Student student, CertificateTemplate template, String verificationCode, LocalDate issuedDate, String qrCodeUrl) {
        this.student = student;
        this.template = template;
        this.verificationCode = verificationCode;
        this.issuedDate = issuedDate;
        this.qrCodeUrl = qrCodeUrl;
    }
    
    public static CertificateBuilder builder() {
        return new CertificateBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public CertificateTemplate getTemplate() { return template; }
    public void setTemplate(CertificateTemplate template) { this.template = template; }
    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }
    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }
    public String getQrCodeUrl() { return qrCodeUrl; }
    public void setQrCodeUrl(String qrCodeUrl) { this.qrCodeUrl = qrCodeUrl; }
    public List<VerificationLog> getVerificationLogs() { return verificationLogs; }
    public void setVerificationLogs(List<VerificationLog> verificationLogs) { this.verificationLogs = verificationLogs; }
    
    public static class CertificateBuilder {
        private Long id;
        private Student student;
        private CertificateTemplate template;
        private String verificationCode;
        private LocalDate issuedDate;
        private String qrCodeUrl;
        private List<VerificationLog> verificationLogs;
        
        public CertificateBuilder id(Long id) { this.id = id; return this; }
        public CertificateBuilder student(Student student) { this.student = student; return this; }
        public CertificateBuilder template(CertificateTemplate template) { this.template = template; return this; }
        public CertificateBuilder verificationCode(String verificationCode) { this.verificationCode = verificationCode; return this; }
        public CertificateBuilder issuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; return this; }
        public CertificateBuilder qrCodeUrl(String qrCodeUrl) { this.qrCodeUrl = qrCodeUrl; return this; }
        public CertificateBuilder verificationLogs(List<VerificationLog> verificationLogs) { this.verificationLogs = verificationLogs; return this; }
        
        public Certificate build() {
            Certificate certificate = new Certificate();
            certificate.id = this.id;
            certificate.student = this.student;
            certificate.template = this.template;
            certificate.verificationCode = this.verificationCode;
            certificate.issuedDate = this.issuedDate;
            certificate.qrCodeUrl = this.qrCodeUrl;
            certificate.verificationLogs = this.verificationLogs;
            return certificate;
        }
    }
}
