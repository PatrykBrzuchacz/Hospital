package pl.softsystem.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.repository.PatientRepository;
import pl.softsystem.hospital.security.repository.UserRepository;

import javax.validation.Valid;


@RepositoryRestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;



    @PostMapping()
    public ResponseEntity<?> savePatient(@Valid @RequestBody Patient patient) {
        String doctorName = SecurityContextHolder.getContext().getAuthentication().getName();
        patient.setUser(userRepository.findByUsername(doctorName));
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@Valid @RequestBody Patient patient, @PathVariable Long id) {
        Patient pat = patientRepository.getPatientById(id);
        pat.setName(patient.getName());
        pat.setPesel(patient.getPesel());
        return ResponseEntity.ok(patientRepository.save(pat));
    }
}
