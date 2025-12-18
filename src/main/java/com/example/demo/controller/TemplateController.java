package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

@RestController
@RequestMapping("/students")
public class CertificateTemplateController{
     private final Templateervice templateservice;
    public StudentController(TemplateService templateservice){
        this.Templateservice=Templateservice;
    }

    
    @PostMapping("/addtemplate")
    public Student addTemplate(@RequestBody Student stu){
        return  Templateservice.addTemplate(stu);
    }
   @GetMapping("/fetchtemplate")
    public List<CertificateTemplate> fetchTemplate(){
      return Templateservice.fetchTemplate();


}

}