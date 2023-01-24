/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Llamasares
 */
@Getter @Setter
public class DtoHabilidades {
    
    private String tituloSkill;
    private int porcentaje;
    private String imgSkill;

    public DtoHabilidades() {
    }

    public DtoHabilidades(String tituloSkill, int porcentaje, String imgSkill) {
        this.tituloSkill = tituloSkill;
        this.porcentaje = porcentaje;
        this.imgSkill = imgSkill;
    }
     
}
