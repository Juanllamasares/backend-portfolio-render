/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.security.service;

import com.portfolio.jell.security.entity.Rol;
import com.portfolio.jell.security.enums.RolNombre;
import com.portfolio.jell.security.repository.IRolRepository;
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
public class RolService {
    @Autowired IRolRepository iRolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepo.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol){
        iRolRepo.save(rol);
    }
}
