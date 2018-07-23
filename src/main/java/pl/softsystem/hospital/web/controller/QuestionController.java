package pl.softsystem.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.ExaminationType;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.application.service.Implementation.ExaminationServiceImplemenetation;
import pl.softsystem.hospital.application.service.Implementation.QuestionServiceImplementation;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class QuestionController {

    @Autowired
    private QuestionServiceImplementation questionServiceImplementation;

    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @Autowired
    private ExaminationRepository examinationRepository;

    @PostMapping("/question/{type}")
    public Question saveQuestion(@RequestBody Question question, @PathVariable ExaminationType type) {
        Examination examination = examinationServiceImplemenetation.getExaminationByType(type);
        question.setExamination(examination);
        return questionServiceImplementation.saveQuestion(question);
    }

    @PostMapping("/question/{id}")
    public Question saveQuestions(@RequestBody Question question, @PathVariable Long id) {
        Examination examination = examinationRepository.getExaminationById(id);
        question.setExamination(examination);
        return questionServiceImplementation.saveQuestion(question);
    }
    @PostMapping("/question")
    public Question saveQuestion(@RequestBody Question question) {
        return questionServiceImplementation.saveQuestion(question);
    }

    @PostMapping("examination/{id}/add")
    public Question add(@RequestBody Question question, @PathVariable("id") Long examinationId) {
        question.setExamination(examinationServiceImplemenetation.findById(examinationId));
        return questionServiceImplementation.saveQuestion(question);
    }

}