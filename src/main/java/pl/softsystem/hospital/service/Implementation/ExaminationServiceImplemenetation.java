package pl.softsystem.hospital.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.repository.ExaminationRepository;
import pl.softsystem.hospital.service.ExaminationService;

@Service
public class ExaminationServiceImplemenetation implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;


    @Override
    public Examination saveExamination(Examination examination){
        return examinationRepository.save(examination);
    }


    @Override
    public Examination findById(Long id) {
        return examinationRepository.findById(id).get();
    }





}
