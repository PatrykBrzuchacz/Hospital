package pl.softsystem.hospital.securityJWT.venues.model.securityModel;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    @Column
    private String name;

    @Column
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    public Role(long id, String description, String name)
    {
        this.id=id; this.name=name; this.description=description;
    };
    public Role(){};

    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "roles" )
    // private Set<User> users = new HashSet<>();;
}
