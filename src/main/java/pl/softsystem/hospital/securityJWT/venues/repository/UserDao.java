package pl.softsystem.hospital.securityJWT.venues.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
