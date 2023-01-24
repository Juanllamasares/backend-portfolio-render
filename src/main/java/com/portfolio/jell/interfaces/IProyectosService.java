package com.portfolio.jell.interfaces;

import java.util.List;
import java.util.Optional;

import com.portfolio.jell.entity.Proyectos;

public interface IProyectosService {
    
    public List<Proyectos> getListProyects();
    
    public Optional<Proyectos> getProyect(int id);
    
    public Optional<Proyectos> getByTituloProyect(String tituloProyect);
    
    public void saveProyect(Proyectos skill);
    
    public void deleteProyect(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByTituloProyect(String tituloProyect);
}
