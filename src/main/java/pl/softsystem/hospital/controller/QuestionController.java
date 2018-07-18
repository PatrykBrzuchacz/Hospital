package pl.softsystem.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.softsystem.hospital.model.Question;
import pl.softsystem.hospital.service.Implementation.QuestionServiceImplementation;
import pl.softsystem.hospital.service.QuestionService;

@RestController
public class QuestionController {

@Autowired
    private QuestionServiceImplementation questionServiceImplementation;

@PostMapping("/question")
    public Question saveQuestion(@RequestBody Question question){
    return questionServiceImplementation.saveQuestion(question);
}
}
