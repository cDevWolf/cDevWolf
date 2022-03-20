
package com.example.passwordapp.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class RegisterAdminUsers {
    private static String encodePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        System.out.println(encoder.encode(password));
        return encoder.encode(password);
    }

    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username("WolfDev")
                .password("{bcrypt}$2a$16$TQujPMIMLvkzxyLM.HkZye9OWpukzl1Hc5SLc.4RrkFxJma6ksrgu")
                .roles("ADMIN_ROLE")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }


}
