package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    // Create certificate
    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return service.addCertificate(certificate);
    }

    // Get certificate by code
    @GetMapping("/code/{code}")
    public Certificate getCertificateByCode(@PathVariable String code) {
        return service.getCertificateByCode(code);
    }

    // Get certificates by student
    @GetMapping("/student/{studentId}")
    public List<Certificate> getCertificatesByStudentId(
            @PathVariable Long studentId) {
        return service.getCertificatesByStudentId(studentId);
    }

    // Get all certificates
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return service.getAllCertificates();
    }

    // Delete certificate
    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        service.deleteCertificate(id);
    }
}
