package pl.softsystem.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.model.ExaminationType;
import pl.softsystem.hospital.model.Question;
import pl.softsystem.hospital.service.Implementation.ExaminationServiceImplemenetation;
import pl.softsystem.hospital.service.Implementation.QuestionServiceImplementation;

@RestController
public class QuestionController {

    @Autowired
    private QuestionServiceImplementation questionServiceImplementation;

    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @PostMapping("/question/{type}")
    public Question saveQuestion(@RequestBody Question question, @PathVariable("type") ExaminationType type) {
        Examination ex = examinationServiceImplemenetation.getExaminationByType(type);
        question.setId_examination(ex);
        return questionServiceImplementation.saveQuestion(question);
    }


    @PostMapping("/question")
    public Question saveQuestion(@RequestBody Question question) {
        return questionServiceImplementation.saveQuestion(question);
    }

    @PostMapping("examination/{id}/add")
    public Question add(@RequestBody Question question, @PathVariable("id") Long examinationId) {
        question.setId_examination(examinationServiceImplemenetation.findById(examinationId));
        return questionServiceImplementation.saveQuestion(question);
    }

}