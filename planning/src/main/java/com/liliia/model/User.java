package com.liliia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String password;

    @Column( nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate date_of_birth;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public User() {

    }

    public User(String username, String password, String role, String email, LocalDate date_of_birth) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    public long getId() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }



    public void setId(Integer id) {
        this.id_user = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id_user +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}