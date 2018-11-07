package pl.softsystem.hospital.security.securityController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.security.repository.UserRepository;
import pl.softsystem.hospital.security.securityModel.LoginUser;
import pl.softsystem.hospital.security.service.UserService;

@RepositoryRestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/signup", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody LoginUser user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
