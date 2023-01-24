/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.jell.interfaces;

import com.portfolio.jell.entity.Experiencia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Llamasares
 */
public interface IExperienciaService {
    public List<Experiencia> getListExp();
    
    public Optional<Experiencia> getExp(int id);
    
    public Optional<Experiencia> getByTituloExp(String tituloExp);
    
    public void saveExp(Experiencia exp);
    
    public void deleteExp(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByTituloExp(String tituloExp);
}
