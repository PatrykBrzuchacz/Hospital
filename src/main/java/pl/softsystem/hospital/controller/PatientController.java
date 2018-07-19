package pl.softsystem.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.softsystem.hospital.model.Patient;
import pl.softsystem.hospital.service.Implementation.PatientServiceImplementation;

import java.util.List;

@RestController
public class PatientController {


    @Autowired
    private PatientServiceImplementation patientServiceImplementation;

    @GetMapping("/")
    public List<Patient> getAll() {
        return patientServiceImplementation.findAllPatients();
    }

    @PostMapping("/")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientServiceImplementation.save(patient);
    }
}
