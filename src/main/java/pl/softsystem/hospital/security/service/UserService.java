package pl.softsystem.hospital.security.service;


import pl.softsystem.hospital.security.securityModel.UserCredentials;
import pl.softsystem.hospital.security.securityModel.User;

public interface UserService {

    User save(UserCredentials user);

}
