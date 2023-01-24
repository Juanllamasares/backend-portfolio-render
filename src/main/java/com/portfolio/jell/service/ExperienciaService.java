/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.service;

import com.portfolio.jell.interfaces.IExperienciaService;
import com.portfolio.jell.entity.Experiencia;
import com.portfolio.jell.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Llamasares
 */
@Service
@Transactional
public class ExperienciaService implements IExperienciaService
{
    @Autowired 
    private IExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> getListExp(){
        return expRepo.findAll();
    }
    
    @Override
    public Optional<Experiencia> getExp(int id){
        return expRepo.findById(id);
    }
    
    @Override
    public Optional<Experiencia> getByTituloExp(String tituloExp){
        return expRepo.findByTituloExp(tituloExp);
    }
    
    @Override
    public void saveExp(Experiencia exp){
        expRepo.save(exp);
    }
    
    @Override
    public void deleteExp(int id){
        expRepo.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return expRepo.existsById(id);
    }
    
    @Override
    public boolean existsByTituloExp(String tituloExp){
        return expRepo.existsByTituloExp(tituloExp);
    }
   
}
