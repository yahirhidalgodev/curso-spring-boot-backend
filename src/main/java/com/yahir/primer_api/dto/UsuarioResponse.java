package com.yahir.primer_api.dto;

public class UsuarioResponse {

    //    Atributos
    private Long id;
    private String nombre;
    private Integer edad;

    //  constructor
    public UsuarioResponse(){
    }

    public UsuarioResponse(Long id, String nombre, Integer edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    //    Getter y  Setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Integer getEdad(){
        return edad;
    }
    public void setEdad(Integer edad){
        this.edad = edad;
    }

}
