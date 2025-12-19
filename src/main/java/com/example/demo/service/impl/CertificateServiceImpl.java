package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Student;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CertificateService;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;

    public CertificateServiceImpl(
            CertificateRepository certificateRepository,
            StudentRepository studentRepository) {
        this.certificateRepository = certificateRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Certificate addCertificate(Certificate certificate) {

        certificate.setId(null);
        Long studentId = certificate.getStudent().getId();

        Student managedStudent = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + studentId));

        certificate.setStudent(managedStudent);

        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificateByCode(String code) {
        return certificateRepository.findByCode(code)
                .orElseThrow(() ->
                        new RuntimeException("Certificate not found with code: " + code));
    }

    @Override
    public List<Certificate> getCertificatesByStudentId(Long studentId) {
        return certificateRepository.findByStudentId(studentId);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
