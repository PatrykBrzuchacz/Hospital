package pl.softsystem.hospital.application.service.Implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.application.service.ExaminationService;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.ExaminationType;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;
import pl.softsystem.hospital.web.dto.ExaminationWithQuestionDto;

import java.util.List;

@Service
public class ExaminationServiceImplemenetation implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;



    public ExaminationWithQuestionDto getWithQuestions(Long id) {
        Examination examination = examinationRepository.getOne(id);
        ExaminationWithQuestionDto dto = new ExaminationWithQuestionDto();
//        dto.setId(examination.getId());
//        dto.setName(examination.getName());
//        dto.setType(examination.getType());
//        dto.setQuestions(examination.getQuestions());
        BeanUtils.copyProperties(examination, dto);
        return dto;
    }
}
