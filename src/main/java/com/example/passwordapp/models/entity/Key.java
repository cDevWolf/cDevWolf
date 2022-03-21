package com.example.passwordapp.models.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "user_keys")
public class Key implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_key;
    private String website;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "keylist_id")
    private KeyList keyList;

    public long getId_key() {
        return id_key;
    }

    public void setId_key(long id_key) {
        this.id_key = id_key;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
}
