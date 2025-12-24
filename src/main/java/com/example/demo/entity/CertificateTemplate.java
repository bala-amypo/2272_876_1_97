package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "certificate_templates",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "template_name")
       })
public class CertificateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name", nullable = false)
    private String templateName;

    @Column(name = "background_url", nullable = false)
    private String backgroundUrl;

    @Column(name = "font_style")
    private String fontStyle;

    @Column(name = "signature_name")
    private String signatureName;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Certificate> certificates;
    
    public CertificateTemplate() {}
    
    public CertificateTemplate(String templateName, String backgroundUrl) {
        this.templateName = templateName;
        this.backgroundUrl = backgroundUrl;
    }
    
    public static CertificateTemplateBuilder builder() {
        return new CertificateTemplateBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public String getBackgroundUrl() { return backgroundUrl; }
    public void setBackgroundUrl(String backgroundUrl) { this.backgroundUrl = backgroundUrl; }
    public String getFontStyle() { return fontStyle; }
    public void setFontStyle(String fontStyle) { this.fontStyle = fontStyle; }
    public String getSignatureName() { return signatureName; }
    public void setSignatureName(String signatureName) { this.signatureName = signatureName; }
    public List<Certificate> getCertificates() { return certificates; }
    public void setCertificates(List<Certificate> certificates) { this.certificates = certificates; }
    
    public static class CertificateTemplateBuilder {
        private Long id;
        private String templateName;
        private String backgroundUrl;
        private String fontStyle;
        private String signatureName;
        private List<Certificate> certificates;
        
        public CertificateTemplateBuilder id(Long id) { this.id = id; return this; }
        public CertificateTemplateBuilder templateName(String templateName) { this.templateName = templateName; return this; }
        public CertificateTemplateBuilder backgroundUrl(String backgroundUrl) { this.backgroundUrl = backgroundUrl; return this; }
        public CertificateTemplateBuilder fontStyle(String fontStyle) { this.fontStyle = fontStyle; return this; }
        public CertificateTemplateBuilder signatureName(String signatureName) { this.signatureName = signatureName; return this; }
        public CertificateTemplateBuilder certificates(List<Certificate> certificates) { this.certificates = certificates; return this; }
        
        public CertificateTemplate build() {
            CertificateTemplate template = new CertificateTemplate();
            template.id = this.id;
            template.templateName = this.templateName;
            template.backgroundUrl = this.backgroundUrl;
            template.fontStyle = this.fontStyle;
            template.signatureName = this.signatureName;
            template.certificates = this.certificates;
            return template;
        }
    }
}
