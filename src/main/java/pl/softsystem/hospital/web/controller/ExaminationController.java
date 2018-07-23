package pl.softsystem.hospital.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.application.service.Implementation.ExaminationServiceImplemenetation;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class ExaminationController {


    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @Autowired
    private ExaminationRepository examinationRepository;
    @GetMapping("/examinations")
    public List<Examination> getAllExamination() {
        return examinationRepository.findAll();
    }

    @PostMapping
    @PostMapping("/examinations")
    public Examination saveExamination(@RequestBody Examination examination){
        return examinationServiceImplemenetation.saveExamination(examination);
    }










}
