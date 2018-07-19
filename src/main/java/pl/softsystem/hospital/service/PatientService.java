package pl.softsystem.hospital.service;

import pl.softsystem.hospital.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAllPatients();

    Patient save(Patient patient);
}