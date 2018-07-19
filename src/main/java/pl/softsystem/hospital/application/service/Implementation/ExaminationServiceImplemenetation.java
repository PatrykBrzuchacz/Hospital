package pl.softsystem.hospital.application.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.application.service.ExaminationService;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.ExaminationType;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;

@Service
public class ExaminationServiceImplemenetation implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;


    @Override
    public Examination saveExamination(Examination examination){
        return examinationRepository.save(examination);
    }

    @Override
    public Long getIdByType(ExaminationType examination) {
        return null;
    }

    public Long getIdByType(Examination examination){
        return examinationRepository.getIdByType(examination);
}

    public Examination findById(Long id) {
        return examinationRepository.findById(id).get();
    }





}
