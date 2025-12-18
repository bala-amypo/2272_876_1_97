package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Certificate certificate;

    private String verificationCode;

    private String verifiedBy;

    private LocalDateTime verifiedAt;

    
    public VerificationLog(Certificate certificate, String verificationCode, String verifiedBy) {
        this.certificate = certificate;
        this.verificationCode = verificationCode;
        this.verifiedBy = verifiedBy;
    }
}
