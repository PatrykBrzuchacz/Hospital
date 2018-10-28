package pl.softsystem.hospital.application.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.application.service.QuestionService;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.domain.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> saveAll(List<Question> questions){
       return questionRepository.saveAll(questions);
    };

}
