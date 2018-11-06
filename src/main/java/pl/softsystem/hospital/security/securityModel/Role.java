package pl.softsystem.hospital.security.securityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String name;

    @Column
    private String description;
    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();
}
