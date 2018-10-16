package pl.softsystem.hospital.assembler;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.softsystem.hospital.application.assembler.PatientAssembler;
import pl.softsystem.hospital.application.service.PatientService;

@SpringBootTest
public class PatientAssemblerTest {

    @Test
    public void shouldMultiply() {
        Assertions.assertThat(PatientAssembler.calcTest(2, 3)).isEqualTo(5);
    }
}
