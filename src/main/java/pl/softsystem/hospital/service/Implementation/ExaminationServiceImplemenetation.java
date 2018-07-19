package pl.softsystem.hospital.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.model.ExaminationType;
import pl.softsystem.hospital.repository.ExaminationRepository;
import pl.softsystem.hospital.service.ExaminationService;

@Service
public class ExaminationServiceImplemenetation implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    public Examination saveExamination(Examination examination){

        return examinationRepository.save(examination);
    }

    @Override
    public Long getIdByType(ExaminationType examination) {
        return null;
    }


/*
public Examination getIdByType(Examination examination){
return examinationRepository.getIdByType(examination);
}
*/

    public Long getIdByType(Examination examination){
        return examinationRepository.getIdByType(examination);
}



}
