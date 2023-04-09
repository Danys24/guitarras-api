/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.guitarra_spring.service;

import com.example.guitarra_spring.entities.Usuarios;
import com.example.guitarra_spring.repositories.UsuariosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Override
    public void crearUsuario(Usuarios usuario) {
        usuariosRepository.save(usuario);
    }

    @Override
    public List<Usuarios> obtenerUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public void eliminarUsuario(String nombre) {
        usuariosRepository.deleteByNombre(nombre);
    }
    
}
