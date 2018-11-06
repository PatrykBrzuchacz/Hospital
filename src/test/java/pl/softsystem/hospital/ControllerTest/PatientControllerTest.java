package pl.softsystem.hospital.ControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.softsystem.hospital.application.service.PatientService;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.repository.PatientRepository;
import pl.softsystem.hospital.web.controller.PatientController;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientController patientController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(patientController)

                .build();
    }

    @Test
    public void test_getAll_success() throws Exception {
        List<Patient> patients = Arrays.asList(
                new Patient((long) 1, "Daenerys", 212311231),
                new Patient((long) 2, "Daenerys2", 1112311231));
        when(patientRepository.findAll()).thenReturn(patients);

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Daenerys")))
                .andExpect(jsonPath("$[0].pesel", is(212311231)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Daenerys2")))
                .andExpect(jsonPath("$[1].pesel", is(1112311231)));
        verify(patientRepository, times(1)).findAll();
        verifyNoMoreInteractions(patientService);
    }

    @Test
    public void saveOrUpdatePatientTest() throws Exception {
        Patient patient = new Patient((long) 1, "Daenerys", 212311231);

        when(patientRepository.save(Matchers.<Patient>any())).thenReturn(patient);
        mockMvc.perform(post("api/patients")
                .param("id", "1")
                .param("name", "Daenerys")
                .param("pesel", "212311231"))
                .andExpect(status().isOk());

        ArgumentCaptor<Patient> patientArgumentCaptor = ArgumentCaptor.forClass(Patient.class);
        verify((patientRepository).save(patientArgumentCaptor.capture()));

        assertEquals(java.util.Optional.of(1L), patientArgumentCaptor.getValue().getId());
        assertEquals("Daenerys", patientArgumentCaptor.getValue().getName());
        assertEquals("212311231", patientArgumentCaptor.getValue().getPesel());
    }

    /*@Test
    public void test_getAll_fail() throws Exception {

        when(patientService.findAllPatients()).thenReturn(null);

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isNotFound());

        verify(patientService, times(1)).findAllPatients();
        verifyNoMoreInteractions(patientService);
    }

    @Test
    public void test_update_and_save_patient_success() throws Exception {
        Patient patient =   new Patient((long) 1, "Daenerys", 212311231);

        when(patientService.save(patient)).thenReturn(patient);

        mockMvc.perform(
                post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(patient)))
                .andExpect(status().isOk());

        verify(patientService, times(1)).save(patient);

        verifyNoMoreInteractions(patientService);
    }
    //converter
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}