package com.example.passwordapp.models.dao.key;

import com.example.passwordapp.models.entity.Key;
import com.example.passwordapp.models.entity.KeyList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KeyDao extends CrudRepository<Key, Long> {
    public List<Key> getAllByKeyList(KeyList keyList);
    @Query("select k from Key k where k.id_key =?1")
    public Key getKeyById(Long id);
}
