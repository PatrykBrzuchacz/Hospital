package pl.softsystem.hospital.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.model.Patient;
import pl.softsystem.hospital.repository.PatientRepository;
import pl.softsystem.hospital.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
}
