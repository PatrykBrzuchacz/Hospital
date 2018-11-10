package pl.softsystem.hospital.SecurityTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import pl.softsystem.hospital.security.config.TokenProvider;

import static org.junit.jupiter.api.Assertions.*;
import static pl.softsystem.hospital.security.config.TokenProvider.generateToken;
import static pl.softsystem.hospital.security.config.TokenProvider.getAuthentication;


public class TokenProviderTest {

    final static String userRole = "ROLE_USER";
    final static String username = "username";
    final String TOKEN_PREFIX = "Bearer";
    final String HEADER_STRING = "Authorization";
    String token;

    MockHttpServletResponse httpServletResponse;
    MockHttpServletRequest httpServletRequest;

    @InjectMocks
    TokenProvider tokenProvider;


    @BeforeEach
    void setUp() {
        httpServletResponse = new MockHttpServletResponse();
        httpServletRequest = new MockHttpServletRequest();

        token = generateToken(username, userRole);

        httpServletResponse.addHeader(HEADER_STRING, token);

    }

    @Test
    public void generateToken_Test() throws Exception {
        assertNotNull(token);
        assertEquals(token, generateToken(username, userRole));

    }

    @Test
    public void addBearerPrefixToAuthenticationHeader_Test() throws Exception {
        String expectedPrefix = TOKEN_PREFIX;
        String resultPrefix = httpServletResponse.getHeader(HEADER_STRING).substring(0, 6);

        assertEquals(expectedPrefix, resultPrefix);
    }

    @Test
    public void addAuthenticationtoResponse_Test() {
        String result = httpServletResponse.getHeader(HEADER_STRING);

        assertNotNull(result);
    }

    @Test
    public void GetAuthentication_Test() {
        httpServletRequest.addHeader(HEADER_STRING, token);
        Authentication resultAuthentication = getAuthentication(httpServletRequest);
        assertAll(
                () ->assertNotNull(resultAuthentication),
        () ->assertEquals(username, resultAuthentication.getName()),
                () ->       assertEquals(userRole, resultAuthentication.getAuthorities().stream().findFirst().get().getAuthority())
        );
    }


    @Nested
    public class GetAuthenticationInvalid {

        @Test
        public void GetAuthenticationWhenTokenIsMissed_Test() {
            Authentication nullAuthentication = getAuthentication(httpServletRequest);
            assertNull(nullAuthentication);
        }

        @Test
        public void getAuthenticationWhenBearerPrefixMissed_Test() throws Exception {
            String bearerTokenWithoutBearerPrefix = TOKEN_PREFIX.substring(6);
            httpServletRequest.addHeader(HEADER_STRING, bearerTokenWithoutBearerPrefix);

            Authentication nullAuthentication = getAuthentication(httpServletRequest);
            assertNull(nullAuthentication);
        }

    }
}
