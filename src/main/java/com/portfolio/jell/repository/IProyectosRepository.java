package com.portfolio.jell.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.jell.entity.Proyectos;

public interface IProyectosRepository extends JpaRepository<Proyectos,Integer>{
    public Optional<Proyectos> findByTituloProyect(String tituloProyect);
    public boolean existsByTituloProyect(String tituloProyect);
}
