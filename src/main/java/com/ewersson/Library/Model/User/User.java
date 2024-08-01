package com.ewersson.Library.Model.User;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = User.TABLE_NAME)
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    public static final String TABLE_NAME = "Users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true)
    private Integer id;

    @Column(name = "login", nullable = false, length = 100, unique = true)
    private String login;

    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "personalCollection", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "book_id")
    private Set<Integer> personalCollection = new HashSet<>();

    public User(String login, UserRole role, String password) {
        this.login = login;
        this.role = role;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Integer> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Set<Integer> personalCollection) {
        this.personalCollection = personalCollection;
    }
}
