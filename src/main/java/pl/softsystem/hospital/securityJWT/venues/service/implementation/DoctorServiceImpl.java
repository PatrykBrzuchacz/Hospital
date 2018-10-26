package pl.softsystem.hospital.securityJWT.venues.service.implementation;

import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Doctor;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.securityJWT.venues.model.securityModel.UserDto;
import pl.softsystem.hospital.securityJWT.venues.repository.DoctorDao;
import pl.softsystem.hospital.securityJWT.venues.repository.RoleDao;
import pl.softsystem.hospital.securityJWT.venues.service.DoctorService;
import pl.softsystem.hospital.securityJWT.venues.service.RoleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service(value = "doctorService")
public class DoctorServiceImpl implements UserDetailsService, DoctorService, RoleService {

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorDao.findByUsername(username);
        if(doctor == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(doctor.getUsername(), doctor.getPassword(), getAuthority(doctor));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Doctor doctor) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        doctor.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<Doctor> findAll() {
        List<Doctor> list = new ArrayList<>();
        doctorDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        doctorDao.deleteById(id);
    }

    @Override
    public Doctor findOne(String username) {
        return doctorDao.findByUsername(username);
    }

    @Override
    public Doctor findById(Long id) {
        return doctorDao.findById(id).get();
    }

    @Override
    public Doctor save(UserDto user) {
        Doctor newDoctor = new Doctor();
        newDoctor.setUsername(user.getUsername());
        newDoctor.setPassword(bcryptEncoder.encode(user.getPassword()));
        //Role role = new Role(2,"User Role", "USER");
//roleDao.save(role);
        System.out.println(roleDao.findByName("DOCTOR").getDescription());


        newDoctor.getRoles().add(roleDao.findByName("DOCTOR"));

        return doctorDao.save(newDoctor);
    }


    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
