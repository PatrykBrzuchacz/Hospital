package pl.softsystem.hospital.service;

import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.model.ExaminationType;

public interface ExaminationService {

    Examination saveExamination(Examination examination);
Examination findById(Long id);
    Long getIdByType(ExaminationType examination);
}
