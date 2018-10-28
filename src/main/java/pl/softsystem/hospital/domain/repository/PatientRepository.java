package pl.softsystem.hospital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.domain.model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    Patient findByPesel(Integer pesel);
    void deleteAll();
    List<Patient> findAll();
    Patient save(Patient patient);
     void deleteById(Long id);
}
