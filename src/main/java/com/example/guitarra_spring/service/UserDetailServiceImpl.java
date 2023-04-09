/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.guitarra_spring.service;

import com.example.guitarra_spring.entities.Usuarios;
import com.example.guitarra_spring.repositories.UsuariosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuariosRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<Usuarios> optUsers = usuarioRepository.findByEmail(username);
        
        if(optUsers.isPresent()){
            Usuarios usuario = new Usuarios();
            usuario = optUsers.get();
            
            
            return User.builder()
                    .username(usuario.getEmail())
                    .password(usuario.getPassword())
                    .roles(usuario.getTipo())
                    .build();
            
            
        } else{
            
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    
}
