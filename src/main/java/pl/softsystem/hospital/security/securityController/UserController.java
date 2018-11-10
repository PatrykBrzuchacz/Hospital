package pl.softsystem.hospital.security.securityController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.security.securityModel.UserCredentials;
import pl.softsystem.hospital.security.service.UserService;

@RepositoryRestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/signup", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody UserCredentials user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
