package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnoreProperties({"certificates"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    @JsonIgnoreProperties({"certificates"})
    private CertificateTemplate template;

    private LocalDate issuedDate;

    @Column(unique = true, nullable = false)
    private String verificationCode; // must start with "VC-"

    @Column(length = 1000)
    private String qrCodeUrl; // Base64 QR code
}
