package pl.softsystem.hospital.securityJWT.venues.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Doctor;

@Repository
public interface DoctorDao extends CrudRepository<Doctor, Long> {
    Doctor findByUsername(String username);
}