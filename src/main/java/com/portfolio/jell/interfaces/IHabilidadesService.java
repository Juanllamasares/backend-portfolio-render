/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.jell.interfaces;

import com.portfolio.jell.entity.Habilidades;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Llamasares
 */
public interface IHabilidadesService {
    public List<Habilidades> getListSkills();
    
    public Optional<Habilidades> getSkill(int id);
    
    public Optional<Habilidades> getByTituloSkill(String tituloSkill);
    
    public void saveSkill(Habilidades skill);
    
    public void deleteSkill(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByTituloSkill(String tituloSkill);
}
