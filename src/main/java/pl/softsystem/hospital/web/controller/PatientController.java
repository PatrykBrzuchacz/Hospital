package pl.softsystem.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.application.service.Implementation.PatientServiceImplementation;
import pl.softsystem.hospital.domain.repository.PatientRepository;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Doctor;
import pl.softsystem.hospital.securityJWT.venues.repository.DoctorDao;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAll() {
        return patientService.findAllPatients();
    }

    @PostMapping("/patients")
    public Patient savePatient(@Valid @RequestBody Patient patient) {
        String doctorName = SecurityContextHolder.getContext().getAuthentication().getName();
        patient.setDoctor(doctorDao.findByUsername(doctorName));
        return patientRepository.save(patient);
    }
    @PutMapping("/patients")
    public Patient updatePatient(@Valid @RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Long id) {
         patientRepository.deleteById(id);
    }
}
