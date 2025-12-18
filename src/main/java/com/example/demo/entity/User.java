package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
@Builder
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique=true)
    private String email;
    private 

}