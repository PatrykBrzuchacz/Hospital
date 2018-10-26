package pl.softsystem.hospital.application.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findByName(String name) {
        return patientRepository.findByName(name);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findByPesel(Integer pesel) {
        return patientRepository.findByPesel(pesel);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public void deleteAll() {
        patientRepository.deleteAll();
    }
}