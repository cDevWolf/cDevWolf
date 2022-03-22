package com.example.passwordapp.models.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "users")
public class User implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    private String username;
    private String password;
    private String role;
    private String name;
    private String lastname;
    private String email;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private KeyList keyList;

    @PrePersist
    private void setKeYListandSerial(){
        this.keyList = new KeyList();
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
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

    public KeyList getKeyList() {
        return keyList;
    }

    public void setKeyList(KeyList keyList) {
        this.keyList = keyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
