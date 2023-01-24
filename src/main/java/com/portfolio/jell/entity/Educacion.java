package com.portfolio.jell.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Llamasares
 */
@Entity
@Getter
@Setter
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEdu;
    @Column(length = 50)
    private String tituloEdu;
    @Column(length = 500)
    private String descripcionEdu;
    @Column(length = 500)
    private String imgEdu;

    public Educacion() {
    }

    public Educacion(String tituloEdu, String descripcionEdu,String imgEdu) {
        this.tituloEdu = tituloEdu;
        this.descripcionEdu = descripcionEdu;
        this.imgEdu = imgEdu;
    }

}
