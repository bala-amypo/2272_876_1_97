package com.example.demo.service.implementation;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.entity.Student;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final CertificateTemplateRepository templateRepository;
    private final StudentRepository studentRepository;

    public CertificateServiceImpl(
            CertificateRepository certificateRepository,
            CertificateTemplateRepository templateRepository,
            StudentRepository studentRepository) {

        this.certificateRepository = certificateRepository;
        this.templateRepository = templateRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {

        
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        
        CertificateTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));

       
        String verificationCode = "VC-" + UUID.randomUUID();

      
        String qrCodeBase64 = "data:image/png;base64," +
                Base64.getEncoder().encodeToString(verificationCode.getBytes());

        Certificate certificate = new Certificate();
        certificate.setStudent(student);
        certificate.setTemplate(template);
        certificate.setIssuedDate(LocalDate.now());
        certificate.setVerificationCode(verificationCode);
        certificate.setQrCode(qrCodeBase64);

        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificate(Long certificateId) {
        return certificateRepository.findById(certificateId)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    @Override
    public Certificate findByVerificationCode(String code) {
        return certificateRepository.findByVerificationCode(code)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    @Override
    public List<Certificate> findByStudentId(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return certificateRepository.findByStudent(student);
    }
}
