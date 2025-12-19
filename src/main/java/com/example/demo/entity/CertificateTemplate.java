package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import.java.util.*;

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

    @NotBlank
    @Pattern(
        regexp = "^(http|https)://.*$",
        message = "Background URL must be a valid HTTP or HTTPS URL"
    )
    @Column(nullable = false)
    private String backgroundUrl;

    private String fontStyle;

    private String signatureName;
     @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    private List<Certificate> certificates;
}
