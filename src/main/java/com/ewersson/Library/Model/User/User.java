package com.ewersson.Library.Model.User;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)

public class User {

    public static final String TABLE_NAME = "Users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true)
    private Integer id;

    @Column(name = "username", nullable = false, length = 100, unique = true)
    @Size(min = 3, max = 100)
    private String username;

    @Column(name = "password", nullable = false, unique = true, length = 100)
    @Size(min = 3, max = 15)
    private String password;

    @ElementCollection
    private Set<Integer> personalCollection = new HashSet<>();

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @Size(min = 3, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 3, max = 100) String username) {
        this.username = username;
    }

    public Set<Integer> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Set<Integer> personalCollection) {
        this.personalCollection = personalCollection;
    }

    public @Size(min = 3, max = 15) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3, max = 15) String password) {
        this.password = password;
    }
}
