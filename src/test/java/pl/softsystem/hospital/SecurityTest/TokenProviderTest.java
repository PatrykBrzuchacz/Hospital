package pl.softsystem.hospital.SecurityTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static pl.softsystem.hospital.security.config.TokenProvider.generateToken;
import static pl.softsystem.hospital.security.config.TokenProvider.getAuthentication;
import static pl.softsystem.hospital.security.securityModel.Constants.HEADER_STRING;

@RunWith(SpringRunner.class)
public class TokenProviderTest {

    String userRole = "ROLE_USER";
    String username = "User";
    MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

    @Test
    public void shouldGenerateToken() throws Exception {
        assertNotNull(generateToken(mockHttpServletResponse, username, userRole));
    }

    @Test
    public void shouldGetAuthentication() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        String jwt = generateToken(mockHttpServletResponse, username, userRole);
        request.addHeader(HEADER_STRING, jwt);
        request.setRequestURI("/api/users");
        assertNotNull(getAuthentication(request));
    }


}
