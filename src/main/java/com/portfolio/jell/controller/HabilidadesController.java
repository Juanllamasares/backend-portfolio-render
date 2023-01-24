/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.controller;

import com.portfolio.jell.dto.DtoHabilidades;
import com.portfolio.jell.entity.Habilidades;
import com.portfolio.jell.security.controller.Mensaje;
import com.portfolio.jell.service.HabilidadesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/skills")
public class HabilidadesController {
    
    @Autowired 
    private HabilidadesService skillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Habilidades>> listSkills(){
        List<Habilidades> listSkills = skillService.getListSkills();
        return new ResponseEntity<>(listSkills,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidades dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getTituloSkill())){
            return new ResponseEntity<>(new Mensaje("Titulo de la habilidad es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        if(skillService.existsByTituloSkill(dtoSkill.getTituloSkill())){
            return new ResponseEntity<>(new Mensaje("Ese titulo de habilidad ya existe"),HttpStatus.BAD_REQUEST);
        }
        Habilidades skill = new Habilidades(dtoSkill.getTituloSkill(),dtoSkill.getPorcentaje(),dtoSkill.getImgSkill());
        skillService.saveSkill(skill);
        
        return new ResponseEntity<>(new Mensaje("Habilidad creada con exito"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody DtoHabilidades dtoSkill){
        if(!skillService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        if(skillService.existsByTituloSkill(dtoSkill.getTituloSkill()) && skillService.getByTituloSkill(dtoSkill.getTituloSkill()).get().getIdSkill()!= id){
            return new ResponseEntity<>(new Mensaje("Esa habilidad ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getTituloSkill())){
            return new ResponseEntity<>(new Mensaje("El titulo es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        
        Habilidades skill = skillService.getSkill(id).get();
        skill.setTituloSkill(dtoSkill.getTituloSkill());
        skill.setPorcentaje(dtoSkill.getPorcentaje());
        skill.setImgSkill(dtoSkill.getImgSkill());
        
        skillService.saveSkill(skill);
        
        return new ResponseEntity<>(new Mensaje("Habilidad editada correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        skillService.deleteSkill(id);
        
        return new ResponseEntity<>(new Mensaje("Habilidad eliminada correctamente"),HttpStatus.OK);
    }
    
    @GetMapping("/getSkill/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidades skill = skillService.getSkill(id).get();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
}
