/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Getter @Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExp;
    @Column(length = 50)
    private String tituloExp;
    @Column(length = 500)
    private String descripcionExp;
    @Column(length = 500)
    private String imgExp;

    public Experiencia() {
    }

    public Experiencia(String tituloExp, String descripcionExp,String imgExp) {
        this.tituloExp = tituloExp;
        this.descripcionExp = descripcionExp;
        this.imgExp = imgExp;
    }
    
}
