package pl.softsystem.hospital.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer pesel;
    @ManyToMany
    @JoinTable(name = "Patient_Examination",
            joinColumns = @JoinColumn(name = "id_patient", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_examination", referencedColumnName = "id"))
    private Set<Examination> examinations = new HashSet<>();
}
