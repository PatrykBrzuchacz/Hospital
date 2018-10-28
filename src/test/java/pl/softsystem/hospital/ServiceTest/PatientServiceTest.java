package pl.softsystem.hospital.ServiceTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.repository.PatientRepository;

import javax.persistence.Table;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

@Autowired
private PatientService patientService;

@Autowired
private PatientRepository patientRepository;
private Patient patient;

@Before
    public void setUp() throws Exception{
    patient=new Patient((long) 1,"Patryk",123456789);
    patientRepository.save(patient);

}
@After
    public void after() throws Exception{
    patientRepository.deleteAll();
}

@Test
    public void getPatientByName_Test(){
    boolean add;
    if(patientRepository.findByName("Patryk")!=null){
        add=true;
    } else add=false;
    assertTrue(add);
}

@Test
    public void savePatient_Test(){
   Patient patient2=new Patient((long) 2,"Patryk2",2123456789);
 boolean add;
   if(patientRepository.save(patient2)!=null){
     add=true;
 } else add = false;
assertTrue(add);
}
@Test
    public void deleteAll_Test(){
    patientRepository.deleteAll();
    assertTrue(patientRepository.findAll().isEmpty());
}

@Test
    public void findAllPatients_Test(){
    List<Patient> patients = patientRepository.findAll();
    assertNotNull(patients);
    assertTrue(patients.size()>0);
 }
    @Test
    public void getPatientByPesel_Test(){
        boolean add;
        if(patientRepository.findByPesel(123456789)!=null){
            add=true;
        } else add=false;
        assertTrue(add);
    }

}
