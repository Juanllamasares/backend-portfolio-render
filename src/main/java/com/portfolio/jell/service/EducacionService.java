/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.service;

import com.portfolio.jell.interfaces.IEducacionService;
import com.portfolio.jell.entity.Educacion;
import com.portfolio.jell.repository.IEducacionRepository;
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
public class EducacionService implements IEducacionService{

    @Autowired
    private IEducacionRepository iEduRepo;
    
    @Override
    public List<Educacion> getListEdu() {
        return iEduRepo.findAll();
    }

    @Override
    public Optional<Educacion> getEdu(int id) {
        return iEduRepo.findById(id);
    }

    @Override
    public Optional<Educacion> getByTituloEdu(String tituloExp) {
        return iEduRepo.findByTituloEdu(tituloExp);
    }

    @Override
    public void saveEdu(Educacion edu) {
        iEduRepo.save(edu);
    }

    @Override
    public void deleteEdu(int id) {
        iEduRepo.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iEduRepo.existsById(id);
    }

    @Override
    public boolean existsByTituloEdu(String tituloEdu) {
        return iEduRepo.existsByTituloEdu(tituloEdu);
    }
    
}
