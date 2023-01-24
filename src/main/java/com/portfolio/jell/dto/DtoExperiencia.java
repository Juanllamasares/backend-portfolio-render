/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Llamasares
 */
@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String tituloExp;
    @NotBlank
    private String descripcionExp;
    
    private String imgExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String tituloExp, String descripcionExp, String imgExp) {
        this.tituloExp = tituloExp;
        this.descripcionExp = descripcionExp;
        this.imgExp = imgExp;
    }
    
}
