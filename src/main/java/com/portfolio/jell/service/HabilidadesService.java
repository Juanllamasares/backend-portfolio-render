/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.service;

import com.portfolio.jell.entity.Habilidades;
import com.portfolio.jell.interfaces.IHabilidadesService;
import com.portfolio.jell.repository.IHabilidadesRepository;
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
public class HabilidadesService implements IHabilidadesService{
    @Autowired
    private IHabilidadesRepository skillRepo;

    @Override
    public List<Habilidades> getListSkills() {
        return skillRepo.findAll();
    }

    @Override
    public Optional<Habilidades> getSkill(int id) {
        return skillRepo.findById(id);
    }

    @Override
    public Optional<Habilidades> getByTituloSkill(String tituloSkill) {
        return skillRepo.findByTituloSkill(tituloSkill);
    }

    @Override
    public void saveSkill(Habilidades skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(int id) {
        skillRepo.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return skillRepo.existsById(id);
    }

    @Override
    public boolean existsByTituloSkill(String tituloSkill) {
        return skillRepo.existsByTituloSkill(tituloSkill);
    }
    
}
