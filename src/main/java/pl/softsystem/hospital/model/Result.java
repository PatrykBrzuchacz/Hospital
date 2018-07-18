package pl.softsystem.hospital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_question")
    private Question question;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patient")
    private Patient patient;
}
