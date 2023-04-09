/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.guitarra_spring.service;

import com.example.guitarra_spring.entities.Guitarra;
import com.example.guitarra_spring.repositories.GuitarrasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class GuitarrasServiceImpl implements GuitarrasService{
    
    @Autowired
    private GuitarrasRepository guitarraRepository;
    
    @Override
    public List<Guitarra> obtenerGuitarras() {
        return guitarraRepository.findAll();
    }

    @Override
    public Optional<Guitarra> obtenerById(Integer id) {
        return guitarraRepository.findById(id);
    }

    @Override
    public void crear(Guitarra guitarra) {
        guitarraRepository.save(guitarra);
    }

    @Override
    public void actualizar(Guitarra guitarra) { 
        
        guitarraRepository.save(guitarra);
    }

    @Override
    public void borrarTodos() {
        
        guitarraRepository.deleteAll();
    }

    @Override
    public void borrarById(Integer id) {
        guitarraRepository.deleteById(id);
    }
    
}
