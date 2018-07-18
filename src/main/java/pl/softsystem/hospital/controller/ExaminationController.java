package pl.softsystem.hospital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.service.Implementation.ExaminationServiceImplemenetation;

@RestController
public class ExaminationController {


    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @PostMapping("/examination")
    public Examination saveExamination (@RequestBody Examination examination){
        return examinationServiceImplemenetation.save(examination);
    }










}
