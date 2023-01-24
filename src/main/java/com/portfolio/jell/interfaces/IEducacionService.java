/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.jell.interfaces;

import com.portfolio.jell.entity.Educacion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Llamasares
 */
public interface IEducacionService {
    
   public List<Educacion> getListEdu();
    
    public Optional<Educacion> getEdu(int id);
    
    public Optional<Educacion> getByTituloEdu(String tituloEdu);
    
    public void saveEdu(Educacion edu);
    
    public void deleteEdu(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByTituloEdu(String tituloEdu);
    
}
