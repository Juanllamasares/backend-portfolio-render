
package com.portfolio.jell.security.service;

import com.portfolio.jell.security.entity.Usuario;
import com.portfolio.jell.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Llamasares
 */
@Service
public class UserDetailsImp implements UserDetailsService{
    @Autowired UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
    
    
}
