package pl.softsystem.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examination")
    private Examination id_examination;
@JsonIgnore
    @OneToMany(mappedBy = "question")
    private Set<Result> results = new HashSet<>();

}
