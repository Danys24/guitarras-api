
package com.example.guitarra_spring.controllers;

import com.example.guitarra_spring.entities.Guitarra;
import com.example.guitarra_spring.service.GuitarrasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 *
 * @author ACER
 */
@RestController
public class GuitarraController {

    @Autowired
    private GuitarrasService guitarrasService;

    private final Logger log = LoggerFactory.getLogger(GuitarraController.class);

    //recuperar las guitarras
    @Operation(summary = "Obten todas las guitarras", description = "Las guitarras solo la pueden ver los usuarios registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Guitarras Encontradas", 
        content = { @Content(mediaType = "application/json", 
        schema = @Schema(implementation = Guitarra.class)) }),
        @ApiResponse(responseCode = "400", description = "Peticion invalida", 
        content = @Content), 
        @ApiResponse(responseCode = "404", description = "Guitarras no encontradas", 
        content = @Content)           
    })
    @GetMapping("/api/guitarras")
    public List<Guitarra> obtenetGuitarras() {

        return guitarrasService.obtenerGuitarras();
    }

    //Crear una guitarra
    @Operation(summary = "Crea una guitarra", description = "")
    @PostMapping("/api/guitarras")
    public ResponseEntity crearGuitarra(@RequestBody Guitarra guitarra) {
        log.info("guitarra Guardada: {}", guitarra);
        guitarrasService.crear(guitarra);

        return ResponseEntity.created(
                URI.create(""))
                .build();
    }

    
    @Operation(summary = "Obten una guitarra por este id", description = "Las guitarras solo la pueden ver los usuarios registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Guitarra Encontrada", 
        content = { @Content(mediaType = "application/json", 
        schema = @Schema(implementation = Guitarra.class)) }),
        @ApiResponse(responseCode = "400", description = "Peticion invalida", 
        content = @Content), 
        @ApiResponse(responseCode = "404", description = "Guitarra no encontrada", 
        content = @Content)           
    })
    @GetMapping("/api/guitarras/{id}")
    public ResponseEntity<Guitarra> obtenerGuitarraById(@Parameter(description = "Para la prueba utilice el id 6") @PathVariable Integer id) {

        Optional<Guitarra> guitarras = guitarrasService.obtenerById(id);

        if (!guitarras.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guitarras.get());
    }

    //Actualizar una guitarra
    @Operation(summary = "Actualiza una guitarra", description = "")
    @PutMapping("/api/guitarras")
    public ResponseEntity actualizarGuitarra(@RequestBody Guitarra guitarra) {
        log.info("guitarra actualizada: {}", guitarra);
        for (Guitarra g : guitarrasService.obtenerGuitarras()) {
            if (g.getId() == guitarra.getId()) {
                guitarrasService.actualizar(guitarra);
                return ResponseEntity.ok().build();
            }
        }

        return ResponseEntity.badRequest().build();

    }

    //Borrar todas las guitarras
    @Operation(summary = "Elimina todas las guitarras", description = "")
    @DeleteMapping("/api/guitarras")
    public ResponseEntity eliminarGuitarras() {

        guitarrasService.borrarTodos();

        return ResponseEntity.ok().build();
    }

    //Borrar una guitarra
    @Operation(summary = "Elimina una guitarra por id", description = "")
    @DeleteMapping("/api/guitarras/{id}")
    public ResponseEntity<Guitarra> eliminarGuitarraPorId(@Parameter(description = "clave primaria de la tabla guitarras") @PathVariable Integer id) {

        Optional<Guitarra> guitarras = guitarrasService.obtenerById(id);

        if (!guitarras.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        guitarrasService.borrarById(id);

        return ResponseEntity.ok().build();
    }

}
