package pl.softsystem.hospital.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.softsystem.hospital.security.securityModel.LoginUser;
import pl.softsystem.hospital.security.securityModel.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAll();

    void deleteById(Long id);

    User getById(Long id);

    User save(LoginUser user);

    boolean existsUserByUsername(String username);
}