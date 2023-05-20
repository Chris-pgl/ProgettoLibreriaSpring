package com.example.demoProgettoLibreriaSpring.security.securityEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String surname;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    private LocalDateTime jwtCreateOn;
    private boolean isActive;
    @Column(length = 36)
    private String activationCode;

    @Column(length = 36)
    private String passwordResetCode;
    //TODO ruoli ( creare classe o enum)
    //TODO jwt


    public User() {
    }


    public LocalDateTime getJwtCreateOn() {
        return jwtCreateOn;
    }

    public void setJwtCreateOn(LocalDateTime jwtCreateOn) {
        this.jwtCreateOn = jwtCreateOn;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPasswordResetCode() {
        return passwordResetCode;
    }

    public void setPasswordResetCode(String passwordResetCode) {
        this.passwordResetCode = passwordResetCode;
    }
}



