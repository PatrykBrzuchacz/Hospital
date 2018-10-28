package pl.softsystem.hospital.securityJWT.venues.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.User;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAll();
    void deleteById(Long id);
    User getById(Long id);
}