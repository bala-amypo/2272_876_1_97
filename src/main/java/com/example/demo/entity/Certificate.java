package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnoreProperties({"certificates"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    @JsonIgnoreProperties({"certificates"})
    private CertificateTemplate template;

    @Column(unique = true, nullable = false)
    private String verificationCode; // Must start with "VC-"

    private String qrCodeUrl; // Base64 QR code image

    private LocalDate issuedDate;

    @OneToMany(mappedBy = "certificate")
    @JsonIgnoreProperties({"certificate"})
    private List<VerificationLog> verificationLogs;
}
