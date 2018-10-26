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

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

@Autowired
private PatientService patientService;

private Patient patient;

@Before
    public void setUp() throws Exception{
    patient=new Patient((long) 1,"Patryk",123456789);
    patientService.save(patient);

}
@After
    public void after() throws Exception{
    patientService.deleteAll();
}

@Test
    public void shouldGetPatientByName(){
    Patient patient2 = patientService.findByName("Patryk");
    assertEquals(patient.getName(),patient2.getName());
    assertEquals(patient.getPesel(),patient2.getPesel());
}

}
