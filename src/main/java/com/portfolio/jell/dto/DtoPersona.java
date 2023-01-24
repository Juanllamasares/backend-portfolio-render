package com.portfolio.jell.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    
    private String nombre;
    private String apellido;
    private String profesion;
    private String descripcion;
    private String img;
    
    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String profesion, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.descripcion = descripcion;
        this.img = img;
    }

    
}
