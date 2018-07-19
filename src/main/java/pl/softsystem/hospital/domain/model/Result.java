package pl.softsystem.hospital.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    public Result(String value, Question question, Patient patient) {
        this.value = value;
        this.question = question;
        this.patient = patient;
    }

}
