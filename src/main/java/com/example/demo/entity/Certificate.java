package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    private String code;

    private String verificationCode;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties({"name", "email", "rollNumber"})
    private Student student;
}
