package pl.softsystem.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.application.service.Implementation.PatientServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientServiceImplementation patientServiceImplementation;

    @GetMapping
    public List<Patient> getAll() {
        return patientServiceImplementation.findAllPatients();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientServiceImplementation.save(patient);
    }
}
