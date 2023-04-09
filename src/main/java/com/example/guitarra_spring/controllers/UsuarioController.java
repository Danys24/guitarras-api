/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.guitarra_spring.controllers;

import com.example.guitarra_spring.entities.Usuarios;
import com.example.guitarra_spring.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ACER
 */
@RestController
public class UsuarioController {
    
    private final Logger log = LoggerFactory.getLogger(UsuarioController.class);
            
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryp = new BCryptPasswordEncoder();
    
    @Operation(summary = "Obten todos los usuarios", description = "")
    @GetMapping("/api/usuarios")
    public List<Usuarios> mostrarUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @Operation(summary = "Crea un nuevo usuario", description = "")
    @PostMapping("/api/usuarios")
    public ResponseEntity crearUsuario(@RequestBody Usuarios usuario){
        log.info("Usuarios creado {}", usuario);
                
        String password = usuario.getPassword();
        usuario.setPassword(bCryp.encode(password));
        usuarioService.crearUsuario(usuario);
        
        return ResponseEntity
                .created(URI.create(""))
                .build();
    }
}
