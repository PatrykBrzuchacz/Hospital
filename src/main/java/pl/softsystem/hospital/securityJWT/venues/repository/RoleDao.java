package pl.softsystem.hospital.securityJWT.venues.repository;


import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
