package com.example.passwordapp.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "keyslists")
public class KeyList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serialItemList;


    @OneToMany(mappedBy = "keyList",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Key> keyList;

    @PrePersist
    public void generateSerialValue(){
        this.serialItemList = UUID.randomUUID().toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialItemList() {
        return serialItemList;
    }

    public void setSerialItemList(String serialItemList) {
        this.serialItemList = serialItemList;
    }

    public List<Key> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<Key> keyList) {
        this.keyList = keyList;
    }
}
