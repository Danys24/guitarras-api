/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.guitarra_spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ACER
 */
@Entity
@Table(name="guitarras")
public class Guitarra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String tipo;
    private String materialCuerdas;
    private String color;
    private String marca;
    private Double precio;
    private Integer cantidad;

    public Guitarra() {
    }

    public Guitarra(Integer id, String tipo, String materialCuerdas, String color, String marca, Double precio, Integer cantidad) {
        this.id = id;
        this.tipo = tipo;
        this.materialCuerdas = materialCuerdas;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterialCuerdas() {
        return materialCuerdas;
    }

    public void setMaterialCuerdas(String materialCuerdas) {
        this.materialCuerdas = materialCuerdas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Guitarra{" + "id=" + id + 
                ", tipo=" + tipo + 
                ", materialCuerdas=" + materialCuerdas + 
                ", color=" + color + 
                ", marca=" + marca + 
                ", precio=" + precio + 
                ", cantidad=" + cantidad + '}';
    }
    
    
    
}
