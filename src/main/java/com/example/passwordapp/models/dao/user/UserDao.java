package com.example.passwordapp.models.dao.user;

import com.example.passwordapp.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
   public User getUserByUsername(String username);
}
