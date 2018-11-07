package pl.softsystem.hospital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.softsystem.hospital.domain.model.Patient;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    Patient findByPesel(Integer pesel);

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    List<Patient> findAll();


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    void deleteById(Long id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Patient getPatientById(Long id);
}
