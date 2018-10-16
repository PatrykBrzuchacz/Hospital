package pl.softsystem.hospital.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, message="Name should have atleast 3 characters")
    private String name;

    @Size(min=8, message="Name should have atleast 3 characters")
    @Size(max=13, message="Name should have no more than 12 characters")
    private Integer pesel;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PatientExamination> patientExaminations = new HashSet<>();

    public PatientExamination createPatientExamination( Patient patient, Examination examination) {
        PatientExamination patientExamination = new PatientExamination();
        patientExamination.setExamination(examination);
        patientExamination.setPatient(patient);
        patientExaminations.add(patientExamination);
        return patientExamination;
    }
}
