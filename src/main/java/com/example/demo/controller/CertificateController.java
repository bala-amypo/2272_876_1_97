import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/generate/{studentId}/{templateId}")
    @PreAuthorize("hasRole('ADMIN')") // Only admins can generate certificates
    public Certificate generate(@PathVariable Long studentId,
                               @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    @GetMapping("/{certificateId}")
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')") // Admin and staff can view certificate
    public Certificate get(@PathVariable Long certificateId) {
        return certificateService.getCertificate(certificateId);
    }

    @GetMapping("/verify/code/{verificationCode}")
    // Public access: anyone can verify certificate
    public Certificate getCertificateByCode(@PathVariable String verificationCode) {
        return certificateService.findByVerificationCode(verificationCode);
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','STAFF')") // Admin and staff can view certificates by student
    public List<Certificate> getCertificatesByStudent(@PathVariable Long studentId) {
        return certificateService.findByStudentId(studentId);
    }
}
