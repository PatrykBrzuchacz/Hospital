package pl.softsystem.hospital.securityJWT.venues.service;


import pl.softsystem.hospital.securityJWT.venues.model.securityModel.User;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
