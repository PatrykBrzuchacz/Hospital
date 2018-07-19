package pl.softsystem.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.domain.model.ExaminationType;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.application.service.Implementation.ExaminationServiceImplemenetation;
import pl.softsystem.hospital.application.service.Implementation.QuestionServiceImplementation;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionServiceImplementation questionServiceImplementation;

    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @PostMapping("/question/{type}")
    public Question saveQuestion(@RequestBody Question question, @PathVariable ExaminationType type) {
        System.out.println("nica");
        Long id = examinationServiceImplemenetation.getIdByType(type);
        System.out.println(id);
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