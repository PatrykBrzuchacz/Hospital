package pl.softsystem.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private ExaminationType type;


@JsonIgnore
    @ManyToMany(mappedBy = "examinations")
    private Set<Patient> patients = new HashSet<>();

    @OneToMany(mappedBy = "id_examination")
    private List<Question> questions = new ArrayList<>();
}
