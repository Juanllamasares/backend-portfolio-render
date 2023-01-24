/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.security.service;

import com.portfolio.jell.security.entity.Usuario;
import com.portfolio.jell.security.repository.IUsuarioRepository;
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
public class UsuarioService {
    @Autowired IUsuarioRepository iUsuarioRepo;
    
    public Optional<Usuario> getNombreUsuario(String nombreUsuario){
        return iUsuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iUsuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioRepo.existsByEmail(email);
    }
    
    public void saveUsuario(Usuario usuario){
        iUsuarioRepo.save(usuario);
    }
}
