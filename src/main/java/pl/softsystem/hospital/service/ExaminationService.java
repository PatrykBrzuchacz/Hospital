package pl.softsystem.hospital.service;

import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.model.ExaminationType;

public interface ExaminationService {

    Examination saveExamination(Examination examination);
<<<<<<< HEAD
    Long getIdByType(ExaminationType examination);
=======
    Examination findById(Long id);
>>>>>>> feb90f9ffe3bf80c055060c954b3fc19606785a4
}
