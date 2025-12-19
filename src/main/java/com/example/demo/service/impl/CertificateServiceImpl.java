package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Student;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final CertificateTemplateRepository templateRepository;

    public CertificateServiceImpl(
            CertificateRepository certificateRepository,
            StudentRepository studentRepository,
            CertificateTemplateRepository templateRepository) {
        this.certificateRepository = certificateRepository;
        this.studentRepository = studentRepository;
        this.templateRepository = templateRepository;
    }

    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<CertificateTemplate> templateOpt = templateRepository.findById(templateId);

        if (studentOpt.isEmpty() || templateOpt.isEmpty()) {
            return null; // or throw exception
        }

        Certificate certificate = Certificate.builder()
                .student(studentOpt.get())
                .template(templateOpt.get())
                .code(UUID.randomUUID().toString()) // unique verification code
                .issueDate(LocalDate.now())
                .build();

        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificate(Long certificateId) {
        return certificateRepository.findById(certificateId).orElse(null);
    }

    @Override
    public Certificate findByVerificationCode(String code) {
        return certificateRepository.findByCode(code);
    }

    @Override
    public List<Certificate> findByStudentId(Long studentId) {
        return certificateRepository.findByStudentId(studentId);
    }
}
