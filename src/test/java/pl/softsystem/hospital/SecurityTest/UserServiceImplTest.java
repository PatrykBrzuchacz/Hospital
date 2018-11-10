package pl.softsystem.hospital.SecurityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.softsystem.hospital.security.repository.UserRepository;
import pl.softsystem.hospital.security.securityModel.Role;
import pl.softsystem.hospital.security.securityModel.UserCredentials;
import pl.softsystem.hospital.security.securityModel.User;
import pl.softsystem.hospital.security.service.RoleService;
import pl.softsystem.hospital.security.service.implementation.UserServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bcryptEncoder;

    @Mock
    RoleService roleService;

    @InjectMocks
    UserServiceImpl userService;


    User user;
    UserCredentials userCredentials;
    Role role;
    String password;
    User user1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        role = new Role(3L, "ROLE_USER", "User Role");
        user = new User(1L, "name", "password", role);
        userCredentials = new UserCredentials("name", "pd");
        user1 = new User();
    }

    @Test
    public void saveUser_Test() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        User insertedUser = userService.save(userCredentials);
        assertAll(
                () -> Assertions.assertNotNull(insertedUser),
                () -> Assertions.assertEquals(user, insertedUser)
        );
    }

    @Test
    public void saveUserFail_Test() {
        when(userRepository.save(any(User.class))).thenReturn(null);
        assertNull(userService.save(userCredentials));
    }

    @Test
    public void getAuthority_Test() {
        assertAll(
                () -> Assertions.assertNotNull(userService.getAuthority(user)),
                () -> Assertions.assertEquals(user.getRoles().getName(), "ROLE_USER")
        );
    }

    @Test
    public void getAuthorityFailUserWithoutRole_Test() {
        assertThrows(NullPointerException.class, () -> {
            userService.getAuthority(user1);
        });
    }

    @Test
    public void loadUser_Test() {
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        Assertions.assertNotNull(userService.loadUserByUsername("exampleUsername"));
    }

    @Test
    public void loadUserFail_Test() {
        when(userRepository.findByUsername(anyString())).thenReturn(user1);
        assertThrows(NullPointerException.class, () -> {
            userService.loadUserByUsername("exampleUsername");
        });
    }
}