package pl.softsystem.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.softsystem.hospital.application.service.Implementation.ExaminationServiceImplemenetation;
import pl.softsystem.hospital.application.service.Implementation.QuestionServiceImplementation;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;
import pl.softsystem.hospital.domain.repository.QuestionRepository;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("hasRole('DOCTOR')")
@RepositoryRestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionServiceImplementation questionServiceImplementation;

    @Autowired
    private ExaminationServiceImplemenetation examinationServiceImplemenetation;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private QuestionRepository questionRepository;


    @PostMapping("/save")
    public Question saveQuestion(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PostMapping("examination/{id}/add")
    public List<Question> add(@Valid @RequestBody List<Question> questions, @PathVariable("id") Long examinationId) {
        Examination examination = examinationRepository.getExaminationById(examinationId);
        for (Question question : questions) {
            question.setExamination(examination);
        }
        return questionServiceImplementation.saveAll(questions);
    }

}