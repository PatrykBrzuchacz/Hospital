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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examination")
    private Examination id_examination;

    public void setId_examination(Examination id_examination) {
        this.id_examination = id_examination;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private Set<Result> results = new HashSet<>();

<<<<<<< HEAD
public Question createQuestion(){
    Question question = new Question();
    question.setId_examination(this.id_examination);
    return question;
}
=======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Examination getId_examination() {
        return id_examination;
    }

    public void setId_examination(Examination id_examination) {
        this.id_examination = id_examination;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
>>>>>>> feb90f9ffe3bf80c055060c954b3fc19606785a4
}
