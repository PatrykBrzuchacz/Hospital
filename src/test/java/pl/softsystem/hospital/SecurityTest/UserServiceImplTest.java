package pl.softsystem.hospital.SecurityTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;
import pl.softsystem.hospital.security.repository.UserRepository;
import pl.softsystem.hospital.security.securityModel.LoginUser;
import pl.softsystem.hospital.security.service.implementation.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    LoginUser user;
    String username = "TestUser";
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        user = new LoginUser(username, "TestUser");
        userService.save(user);

    }

    @After
    public void tearDown() throws Exception {
        if (userRepository.existsUserByUsername(username))
            userRepository.deleteById(userRepository.findByUsername(username).getId());
    }

    @Test
    public void shouldAddUser() throws Exception {
        String actual = userRepository.findByUsername(username).getUsername();
        assertEquals(username, actual);

    }

    @Test
    public void shouldLoadUser() throws Exception {
        assertNotNull(userService.loadUserByUsername(username));
    }

    @Test
    public void shouldGetAuthority() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
        assertEquals(userService.getAuthority(userRepository.findByUsername(username)), authorities);
    }
}