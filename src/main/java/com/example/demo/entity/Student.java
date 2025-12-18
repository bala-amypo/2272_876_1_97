package com.example.demo.entity;
import lombok.Builder;

import jakarta.persistence.*;
@Entity
@Builder
public class Student{
    @Id;
    private long id;
    private String name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String rollNumber;
       
    public Student() {
    }

   
    public Student(long id, String name, String email, String rollNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rollNumber = rollNumber;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

}