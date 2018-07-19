package pl.softsystem.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.softsystem.hospital.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
