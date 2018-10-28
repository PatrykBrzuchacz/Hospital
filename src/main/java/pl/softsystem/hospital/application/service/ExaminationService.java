package pl.softsystem.hospital.application.service;

import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.ExaminationType;
import pl.softsystem.hospital.web.dto.ExaminationWithQuestionDto;

import java.util.List;

public interface ExaminationService {
    public ExaminationWithQuestionDto getWithQuestions(Long id);
}
