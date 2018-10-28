package pl.softsystem.hospital.securityJWT.venues.service;


import pl.softsystem.hospital.securityJWT.venues.model.securityModel.User;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.LoginUser;

public interface UserService {

    User save(LoginUser user);

}
