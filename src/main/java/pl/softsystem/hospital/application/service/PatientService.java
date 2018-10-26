package pl.softsystem.hospital.application.service;

import pl.softsystem.hospital.domain.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAllPatients();

    Patient findByName(String name);
    Patient save(Patient patient);
    void deleteAll();
    Patient findByPesel(Integer pesel);
}