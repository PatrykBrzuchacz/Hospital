package pl.softsystem.hospital.security.service;


import pl.softsystem.hospital.security.securityModel.LoginUser;
import pl.softsystem.hospital.security.securityModel.User;

public interface UserService {

    User save(LoginUser user);

}
