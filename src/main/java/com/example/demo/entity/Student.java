package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "students", 
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"email"}),
           @UniqueConstraint(columnNames = {"rollNumber"})
       })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String rollNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Certificate> certificates;
}
