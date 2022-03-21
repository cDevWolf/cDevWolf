package com.example.passwordapp.models.service.user;
import com.example.passwordapp.models.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
public interface UserService{
    public List<User> getAllUsers();
    public void insertUser(User user);
    public void deleteByUser(User user);
    public User getUserById(Long id);
    public User getUserByUsername(String username);
}
