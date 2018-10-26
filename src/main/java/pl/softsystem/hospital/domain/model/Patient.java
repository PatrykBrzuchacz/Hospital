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
    public Patient(Long id, String name, Integer pesel){
        this.id=id;
        this.name=name;
        this.pesel=pesel;
    }
    public Patient(){}
}
