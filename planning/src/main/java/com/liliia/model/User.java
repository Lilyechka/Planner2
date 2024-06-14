package com.liliia.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.*;

@Entity
@Table (name = "users")
public class User implements  UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate date_of_birth;

    @Column(name = "date_of_registration")
    private LocalDateTime dateOfRegistration;

    @PrePersist
    protected void onCreate() {
        dateOfRegistration = LocalDateTime.now();
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public User() {

    }

    public User(String name, String password, String role, String email, LocalDate birth_date) {
        this.username = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.date_of_birth = birth_date;
    }

    public Integer getId() {
        return id_user;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() { return  email; }

    public LocalDate getBirth_date() { return date_of_birth; }

    public void setId(Integer id) {
        this.id_user = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) { this.email = email; }

    public void setBirthDate(LocalDate birth_date) { this.date_of_birth = birth_date; }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id_user +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + getRole()));
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

}


