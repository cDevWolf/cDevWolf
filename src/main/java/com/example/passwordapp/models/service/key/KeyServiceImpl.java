package com.example.passwordapp.models.service.key;

import com.example.passwordapp.models.dao.key.KeyDao;
import com.example.passwordapp.models.entity.Key;
import com.example.passwordapp.models.entity.KeyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeyServiceImpl implements KeyService{
    @Autowired
    private KeyDao keyDao;
    @Override
    public void insertKey(Key key) {
        keyDao.save(key);
    }

    @Override
    public List<Key> getAllKeysByKeyListId(KeyList keyList) {
        return keyDao.getAllByKeyList(keyList);
    }

    @Override
    public Key getKeyById(Long id) {
        return keyDao.getKeyById(id);
    }
}
