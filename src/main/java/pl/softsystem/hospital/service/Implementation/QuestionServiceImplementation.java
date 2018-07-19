package pl.softsystem.hospital.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.model.Question;
import pl.softsystem.hospital.repository.QuestionRepository;
import pl.softsystem.hospital.service.QuestionService;

import javax.management.QueryExp;

@Service
public class QuestionServiceImplementation implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {

        return questionRepository.save(question);
    }


}
