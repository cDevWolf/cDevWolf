package com.example.passwordapp.models.service.key;

import com.example.passwordapp.models.entity.Key;
import com.example.passwordapp.models.entity.KeyList;

import java.util.List;

public interface KeyService {
    public void insertKey(Key key);
    public List<Key> getAllKeysByKeyListId(KeyList keyList);
    public Key getKeyById(Long id);
}
