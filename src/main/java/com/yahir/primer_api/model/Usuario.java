package com.yahir.primer_api.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres." )
    private String nombre;

    @Min(value = 1, message = "El valor debe ser mayor a cero")
    private Integer edad;

    public Usuario(){
    }

    public Usuario(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
}
