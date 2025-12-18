package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
@Builder
public class CertificateTemplate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String templateName;
    @NotBlank
    @Pattern(
        regexp = "^(http|https)://.*$",
        message = "Background URL must be a valid HTTP or HTTPS URL"
    )
    private String backgroundUrl;
    private String fontStyle;
    private String signatureName;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }
     
    public CertificateTemplate() {
    }

   
    public CertificateTemplate(long id, String templateName, String backgroundUrl,
                               String fontStyle, String signatureName) {
        this.id = id;
        this.templateName = templateName;
        this.backgroundUrl = backgroundUrl;
        this.fontStyle = fontStyle;
        this.signatureName = signatureName;
    }
}