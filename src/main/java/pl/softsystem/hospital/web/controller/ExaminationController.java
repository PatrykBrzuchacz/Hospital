package pl.softsystem.hospital.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.application.service.Implementation.ExaminationServiceImplemenetation;

@RestController
@RequestMapping("/api/examinations")
public class ExaminationController {


    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @PostMapping
    public Examination saveExamination(@RequestBody Examination examination){
        return examinationServiceImplemenetation.saveExamination(examination);
    }










}
