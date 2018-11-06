package pl.softsystem.hospital.application.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.domain.repository.PatientRepository;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


}