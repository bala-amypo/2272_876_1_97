// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;
// import java.util.List;

// @Entity
// @Table(name = "templates")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class CertificateTemplate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String templateName;

//     private String description;

//     @Lob
//     private String content;

//     @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
//     private List<Certificate> certificates;
// }
