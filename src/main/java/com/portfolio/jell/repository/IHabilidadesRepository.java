/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.jell.repository;

import com.portfolio.jell.entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Llamasares
 */
public interface IHabilidadesRepository extends JpaRepository<Habilidades, Integer> {
    public Optional<Habilidades> findByTituloSkill(String tituloSkill);
    public boolean existsByTituloSkill(String tituloSkill);
}
