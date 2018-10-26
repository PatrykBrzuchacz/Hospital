package pl.softsystem.hospital.securityJWT.venues.service;


import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Role;
public interface RoleService {
    Role findByName(String name);
}
