package pl.softsystem.hospital.securityJWT.venues.controller.securityController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.User;

import pl.softsystem.hospital.securityJWT.venues.model.securityModel.LoginUser;
import pl.softsystem.hospital.securityJWT.venues.repository.UserDao;

import pl.softsystem.hospital.securityJWT.venues.service.UserService;


import java.util.List;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService doctorService;

    @Autowired
    private UserDao doctorDao;
    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return doctorDao.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('DOCTOR')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return doctorDao.getById(id);
    }


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody LoginUser user){
        return doctorService.save(user);
    }



}
