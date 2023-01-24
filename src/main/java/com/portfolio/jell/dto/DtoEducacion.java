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
public class DtoEducacion {
    
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String descripcionEdu;
    
    private String imgEdu;

    public DtoEducacion() {
    }

    public DtoEducacion(String tituloEdu, String descripcionEdu, String imgEdu) {
        this.tituloEdu = tituloEdu;
        this.descripcionEdu = descripcionEdu;
        this.imgEdu = imgEdu;
    }
}
