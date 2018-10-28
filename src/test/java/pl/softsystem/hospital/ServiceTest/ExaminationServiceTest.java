package pl.softsystem.hospital.ServiceTest;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.softsystem.hospital.application.service.ExaminationService;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.application.service.QuestionService;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.ExaminationType;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;
import pl.softsystem.hospital.web.dto.ExaminationWithQuestionDto;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationServiceTest {


    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private QuestionService questionService;
    private Examination examination;
    private ExaminationType examinationType;

    @Before
    public void setUp() throws Exception {
        examination = new Examination((long) 1,"exam1",examinationType.MORFOLOGIA);
        examinationRepository.save(examination);
    }

    @After
    public void after() throws Exception {
        examinationRepository.deleteAll();
    }
    @Test
    public void saveExamination_Test(){
      Examination  examination2 = new Examination((long) 1,"exam1",examinationType.MORFOLOGIA);
        boolean add;
        if(examinationRepository.save(examination2)!=null){
            add=true;
        } else add = false;
        assertTrue(add);
    }
/*
   @Test
    public void getExaminationById_Test(){
        boolean add;
        if(examinationService.findById(1L).getId()!=null){
            add=true;
        } else add=false;
        assertTrue(add);
    }*/
    @Test
    public void deleteAll_Test(){
        examinationRepository.deleteAll();
        assertTrue(examinationRepository.findAll().isEmpty());
    }

   /* @Test
    public void getWithQuestions_Test(){
        Question questions = new Question(1L, "question1",examination);
        questionService.saveQuestion(questions);
        examination.setQuestions((List<Question>) questions);
        ExaminationWithQuestionDto dto = new ExaminationWithQuestionDto();
       dto.setId(examination.getId());
       dto.setName(examination.getName());
       dto.setType(examination.getType());
       dto.setQuestions(examination.getQuestions());
        assertEquals(dto,examinationService.getWithQuestions(1L));
    }
*/

}