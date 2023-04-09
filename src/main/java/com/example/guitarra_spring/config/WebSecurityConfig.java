package com.example.guitarra_spring.config;

import com.example.guitarra_spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author ACER
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private UserDetailsService userDetail;
    
    @Bean
    @Order(1)
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
           http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/usuarios/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        return http.build();
        
        /*   
        .csrf().disable()
                .securityMatcher("/api/usuarios/**")
                .authorizeHttpRequests(authorize -> authorize
                .anyRequest().hasRole("ADMIN"))
                .httpBasic();
        */
    }
    
    /*
    @Bean
    SecurityFilterChain filterChain2(HttpSecurity http) throws Exception{
           http
                .csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated())
                .formLogin();
           
        return http.build();
    }
    */
    
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetail)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }
    
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}

