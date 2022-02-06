package ru.alex.kuznetsov.project.product.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_type")
public class UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "userTypeUser")
    private Set<UserEntity> users;

    public UserTypeEntity(){
    }

    public UserTypeEntity(Integer id, String name, String description, Set<UserEntity> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

}
