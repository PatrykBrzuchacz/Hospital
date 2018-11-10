package pl.softsystem.hospital.security.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.security.repository.RoleRepository;
import pl.softsystem.hospital.security.securityModel.Role;
import pl.softsystem.hospital.security.service.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER");
    }
}