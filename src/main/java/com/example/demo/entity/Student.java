package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
@Builder
public class Student{
    @Id;
    private long id;
    private String name;
    
}