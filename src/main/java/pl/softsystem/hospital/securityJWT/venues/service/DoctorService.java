package pl.softsystem.hospital.securityJWT.venues.service;


import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Doctor;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.UserDto;

import java.util.List;

public interface DoctorService {

    Doctor save(UserDto user);
    List<Doctor> findAll();
    void delete(long id);
    Doctor findOne(String username);

    Doctor findById(Long id);
}
