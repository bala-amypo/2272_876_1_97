package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "certificates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "template_id", nullable = false)
    private CertificateTemplate template;

    private LocalDate issuedDate;

    
    @Column(columnDefinition = "TEXT")
    private String qrCodeUrl;


    @Column(unique = true, nullable = false, updatable = false)
    private String verificationCode;

   
    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VerificationLog> verificationLogs;
}
