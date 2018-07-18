package pl.softsystem.hospital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examination")
    private Examination examination;

    @OneToMany(mappedBy = "question")
    private Set<Result> results = new HashSet<>();

}
