package pl.softsystem.hospital.securityJWT.venues.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

import static pl.softsystem.hospital.securityJWT.venues.model.securityModel.Constants.*;

@Component
public class TokenProvider {


    public static void generateToken(HttpServletResponse res, String username, String userRole ) {
        Map<String, Object> authorityClaims = new HashMap<String, Object>();
        authorityClaims.put(AUTHORITIES_KEY, userRole);
        String JWT = Jwts.builder().setClaims(authorityClaims)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }



    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null && token.toLowerCase().contains(TOKEN_PREFIX.toLowerCase())) {
            String user = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody().getSubject();
            Claims tokenClaims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();


            Collection<? extends GrantedAuthority> authorities = Arrays
                    .asList(tokenClaims.get(AUTHORITIES_KEY).toString().split(",")).stream()
                    .map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, authorities) : null;
        }
        return null;
    }

}