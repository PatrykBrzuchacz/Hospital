package pl.softsystem.hospital.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.softsystem.hospital.security.securityModel.User;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    List<User> findAll();
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteById(Long id);
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    User getById(Long id);

    boolean existsUserByUsername(String username);
}