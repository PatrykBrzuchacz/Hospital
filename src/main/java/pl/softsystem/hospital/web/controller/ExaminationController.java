package pl.softsystem.hospital.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.application.service.Implementation.ExaminationServiceImplemenetation;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;
import pl.softsystem.hospital.domain.repository.QuestionRepository;
import pl.softsystem.hospital.web.dto.ExaminationWithQuestionDto;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("hasRole('DOCTOR')")
@RepositoryRestController
@RequestMapping("examination")
public class ExaminationController {


    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private QuestionRepository questionRepository;


    @GetMapping
    public List<Examination> getAllExamination() {
        return examinationRepository.findAll();
    }

    @GetMapping("{/id}")
    public ExaminationWithQuestionDto getWithQuestions(@PathVariable Long id) {
        return examinationServiceImplemenetation.getWithQuestions(id);
    }

    @PostMapping("/save")
    public Examination saveExamination(@Valid @RequestBody Examination examination) {
        return examinationRepository.save(examination);
    }

    @PutMapping("/update")
    public Examination updateExamination(@Valid @RequestBody Examination examination) {
        return examinationRepository.save(examination);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExamination(@PathVariable("id") Long id) {
        examinationRepository.deleteById(id);
    }


    @GetMapping("/{id}/questions")
    public List<Question> DisplayQuestions(@PathVariable Long id) {
        return questionRepository.findAllByExaminationId(id);
    }


}
