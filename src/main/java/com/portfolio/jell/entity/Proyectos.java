package com.portfolio.jell.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProy;
    @Column(length = 50)
    private String tituloProyect;
    @Column(length = 500)
    private String urlProyecto;
    @Column(length = 500)
    private String descripcionProyect;
    @Column(length = 500)
    private String imgProyect;
    
    public Proyectos() {
    }

    public Proyectos(String tituloProyect, String urlProyecto, String descripcionProyect, String imgProyect) {
        this.tituloProyect = tituloProyect;
        this.urlProyecto = urlProyecto;
        this.descripcionProyect = descripcionProyect;
        this.imgProyect = imgProyect;
    }

    
}
