package pl.softsystem.hospital.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, message = "Name should have atleast 3 characters")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private ExaminationType type;
    @OneToMany(mappedBy = "examination", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    public Examination(Long id, String name, ExaminationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
