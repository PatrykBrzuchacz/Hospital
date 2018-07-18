package pl.softsystem.hospital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Examination {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ExaminationType examinationType;
    private String name;
    @ManyToMany(mappedBy = "examinations")
    private Set<Patient> patients = new HashSet<>();
    @OneToMany(mappedBy = "examination")
    private List<Question> questions = new ArrayList<>();
}
