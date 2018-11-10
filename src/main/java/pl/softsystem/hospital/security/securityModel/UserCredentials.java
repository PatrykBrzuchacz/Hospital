package pl.softsystem.hospital.security.securityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCredentials {

    private String username;
    private String password;

}
