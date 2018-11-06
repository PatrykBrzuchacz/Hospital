package pl.softsystem.hospital.application.service;

import pl.softsystem.hospital.web.dto.ExaminationWithQuestionDto;

public interface ExaminationService {
    public ExaminationWithQuestionDto getWithQuestions(Long id);
}
