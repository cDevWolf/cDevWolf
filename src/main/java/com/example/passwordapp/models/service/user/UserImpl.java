package com.example.passwordapp.models.service.user;

import com.example.passwordapp.models.dao.user.UserDao;
import com.example.passwordapp.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public void insertUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteByUser(User user) {
        userDao.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
