package pl.softsystem.hospital.security.securityModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginUser {

    private String username;
    private String password;

}
