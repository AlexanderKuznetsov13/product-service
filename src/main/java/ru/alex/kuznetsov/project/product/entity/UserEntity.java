package ru.alex.kuznetsov.project.product.entity;

import javax.persistence.*;

@Entity
@Table(name="user", schema = "product")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserTypeEntity userTypeUser;

    public UserEntity(){
    }

    public UserEntity(Integer id, String name, String surname, String middlename, String email, String login, String password, UserTypeEntity userTypeUser) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.email = email;
        this.login = login;
        this.password = password;
        this.userTypeUser = userTypeUser;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypeEntity getUserTypeUser() {
        return userTypeUser;
    }

    public void setUserTypeUser(UserTypeEntity userTypeUser) {
        this.userTypeUser = userTypeUser;
    }
}
