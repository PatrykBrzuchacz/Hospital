package pl.softsystem.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
