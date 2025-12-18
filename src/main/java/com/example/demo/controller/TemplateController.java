package com.example.demo.controller;
import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

@RestController
@RequestMapping("/templates")
public class CertificateTemplateController{
     private final Templateervice templateservice;
    public StudentController(TemplateService templateservice){
        this.Templateservice=Templateservice;
    }

    
    @PostMapping("/addtemplate")
    public Student addTemplate(@RequestBody CertificateTemplate temp){
        return  Templateservice.addTemplate(temp);
    }
   @GetMapping("/fetchtemplate")
    public List<CertificateTemplate> fetchTemplate(){
      return Templateservice.fetchTemplate();


}

}