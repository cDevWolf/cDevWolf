package com.example.passwordapp.models.security.UserDetails;

import com.example.passwordapp.models.entity.User;
import com.example.passwordapp.models.service.user.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new UserForUserDetails(user);
    }
}
