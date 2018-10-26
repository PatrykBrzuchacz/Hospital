package pl.softsystem.hospital.securityJWT.venues.controller.securityController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Doctor;

import pl.softsystem.hospital.securityJWT.venues.model.securityModel.UserDto;
import pl.softsystem.hospital.securityJWT.venues.service.DoctorService;


import java.util.List;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private DoctorService doctorService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<Doctor> listUser(){
        return doctorService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('DOCTOR')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Doctor getOne(@PathVariable(value = "id") Long id){
        return doctorService.findById(id);
    }


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public Doctor saveUser(@RequestBody UserDto user){
        return doctorService.save(user);
    }



}
