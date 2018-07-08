package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Platform {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public String name;

    @OneToMany(
            mappedBy = "platform",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Application> applications = new ArrayList<>();



    @ManyToMany(mappedBy = "platforms")
    private List<User> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Application> getApplication() {
        return applications;
    }

    public void setApplications(List<Application> application) {
        this.applications = application;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}