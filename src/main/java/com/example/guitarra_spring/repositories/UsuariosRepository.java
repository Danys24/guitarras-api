/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.guitarra_spring.repositories;

import com.example.guitarra_spring.entities.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACER
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    Optional<Usuarios> deleteByNombre(String nombre);
    Optional<Usuarios> findByEmail(String email);
}
