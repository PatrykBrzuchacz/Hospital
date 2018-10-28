package pl.softsystem.hospital.application.service;

import pl.softsystem.hospital.domain.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> saveAll(List<Question> questions);

}
