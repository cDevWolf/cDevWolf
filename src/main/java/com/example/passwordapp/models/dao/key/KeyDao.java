package com.example.passwordapp.models.dao.key;

import com.example.passwordapp.models.entity.Key;
import org.springframework.data.repository.CrudRepository;

public interface KeyDao extends CrudRepository<Key, Long> {
}
