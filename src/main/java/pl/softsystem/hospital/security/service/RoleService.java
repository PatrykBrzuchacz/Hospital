package pl.softsystem.hospital.security.service;


import pl.softsystem.hospital.security.securityModel.Role;

public interface RoleService {
    Role findByName(String name);
}
