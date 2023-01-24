package com.portfolio.jell.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.jell.entity.Proyectos;
import com.portfolio.jell.interfaces.IProyectosService;
import com.portfolio.jell.repository.IProyectosRepository;

@Service
@Transactional
public class ProyectoService implements IProyectosService{

    @Autowired
    private IProyectosRepository iProyectRepo;

    @Override
    public void deleteProyect(int id) {
        iProyectRepo.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iProyectRepo.existsById(id);
    }

    @Override
    public boolean existsByTituloProyect(String tituloProyect) {
        return iProyectRepo.existsByTituloProyect(tituloProyect);
    }

    @Override
    public Optional<Proyectos> getByTituloProyect(String tituloProyect) {
        return iProyectRepo.findByTituloProyect(tituloProyect);
    }

    @Override
    public List<Proyectos> getListProyects() {
        return iProyectRepo.findAll();
    }

    @Override
    public Optional<Proyectos> getProyect(int id) {
        return iProyectRepo.findById(id);
    }

    @Override
    public void saveProyect(Proyectos skill) {
        iProyectRepo.save(skill);
    }
    
}
