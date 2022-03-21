package com.example.passwordapp.configuration.security;

import com.example.passwordapp.models.security.UserDetails.UserDetailsServiceImpl;
import com.example.passwordapp.models.security.UserDetails.UserForUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

@Configuration
@EnableWebSecurity
public class ConfigAuthFilter{
    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorize -> {
                            try {
                                authorize
                                        .mvcMatchers("/v1/app").hasRole("ADMIN_ROLE")
                                        .mvcMatchers("/login","/logout","/css/**",
                                                "/js/**","/scss/**","/img/**").permitAll()
                                        .anyRequest().authenticated()
                                        .and().formLogin().loginPage("/login").defaultSuccessUrl("/v1/", true)
                                        .and().logout()
                                        .and().authenticationProvider(authenticationProvider());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



}
