/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.guitarra_spring.service;

import com.example.guitarra_spring.entities.Usuarios;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ACER
 */
public interface UsuarioService {
    void crearUsuario(Usuarios usuario);
    List<Usuarios> obtenerUsuarios();
    void eliminarUsuario(String nombre);
    
}
