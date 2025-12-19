package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "certificate_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String templateName;

    @Column(nullable = false)
    private String backgroundUrl;

    private String fontStyle;

    private String signatureName;

    @OneToMany(mappedBy = "template")
    private List<Certificate> certificates;
}
