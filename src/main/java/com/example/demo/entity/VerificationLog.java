package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
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
    @JoinColumn(name = "certificate_id", nullable = false)
    private Certificate certificate;

    @Column(nullable = false)
    private String verificationCode;

    @Column(nullable = false)
    private String status;   // SUCCESS or FAILED

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false)
    private LocalDateTime verifiedAt;
}
