package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "certificate_templates",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "template_name")
       })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name", nullable = false)
    private String templateName;

    @Column(name = "background_url", nullable = false)
    private String backgroundUrl;

    @Column(name = "font_style")
    private String fontStyle;

    @Column(name = "signature_name")
    private String signatureName;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    private List<Certificate> certificates;
}
