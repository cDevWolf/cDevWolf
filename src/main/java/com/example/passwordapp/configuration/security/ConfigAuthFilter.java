package com.example.passwordapp.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

@Configuration
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
                                        .and().logout();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
        return http.build();
    }



}
