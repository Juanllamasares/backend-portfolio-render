/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.controller;

import com.portfolio.jell.dto.DtoPersona;
import com.portfolio.jell.entity.Persona;
import com.portfolio.jell.security.controller.Mensaje;
import com.portfolio.jell.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Llamasares
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaServ;

    @PostMapping("/create")
    public String crear(@RequestBody Persona persona) {
        personaServ.savePersona(persona);
        return "Persona creada correctamente";
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody DtoPersona dtoPer){
        
        
        Persona per = personaServ.getPersona(id).get();
        
        per.setNombre(dtoPer.getNombre());
        per.setApellido(dtoPer.getApellido());
        per.setProfesion(dtoPer.getProfesion());
        per.setDescripcion(dtoPer.getDescripcion());
        per.setImg(dtoPer.getImg());
        
        personaServ.savePersona(per);
        
        return new ResponseEntity<>(new Mensaje("Persona editada correctamente"),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable("id") int id) {
        Persona persona = personaServ.getPersona(id).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

}
