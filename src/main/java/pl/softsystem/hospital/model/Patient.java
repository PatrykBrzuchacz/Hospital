package pl.softsystem.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer pesel;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Patient_Examination",
            joinColumns = @JoinColumn(name = "id_patient", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_examination", referencedColumnName = "id"))
    private Set<Examination> examinations = new HashSet<>();
}
