/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.guitarra_spring.service;

import com.example.guitarra_spring.entities.Guitarra;
import java.util.*;

/**
 *
 * @author ACER
 */
public interface GuitarrasService {
    
    List<Guitarra> obtenerGuitarras();
    Optional<Guitarra> obtenerById(Integer id); 
    void crear(Guitarra guitarra);
    void actualizar(Guitarra guitarra);
    void borrarTodos();
    void borrarById(Integer id);

}
