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
import pl.softsystem.hospital.service.QuestionService;

@RestController
public class QuestionController {

@Autowired
    private QuestionServiceImplementation questionServiceImplementation;
    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;
@PostMapping("/question/{type}")
    public Question saveQuestion(@RequestBody Question question, @PathVariable ExaminationType type){
    System.out.println("nica");
Long id = examinationServiceImplemenetation.getIdByType(type);
    System.out.println(id);
    return questionServiceImplementation.saveQuestion(question);
}

}
