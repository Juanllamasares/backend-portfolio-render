/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.jell.controller;

import com.portfolio.jell.dto.DtoEducacion;
import com.portfolio.jell.entity.Educacion;
import com.portfolio.jell.security.controller.Mensaje;
import com.portfolio.jell.service.EducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired 
    private EducacionService eduService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> listEdu(){
        List<Educacion> listEdu = eduService.getListEdu();
        return new ResponseEntity<>(listEdu,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getTituloEdu())){
            return new ResponseEntity<>(new Mensaje("Titulo de la educacion es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        if(eduService.existsByTituloEdu(dtoEdu.getTituloEdu())){
            return new ResponseEntity<>(new Mensaje("Ese titulo de educacion ya existe"),HttpStatus.BAD_REQUEST);
        }
        Educacion edu = new Educacion(dtoEdu.getTituloEdu(),dtoEdu.getDescripcionEdu(),dtoEdu.getImgEdu());
        eduService.saveEdu(edu);
        
        return new ResponseEntity<>(new Mensaje("Educacion creada con exito"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody DtoEducacion dtoEdu){
        if(!eduService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        if(eduService.existsByTituloEdu(dtoEdu.getTituloEdu()) && eduService.getByTituloEdu(dtoEdu.getTituloEdu()).get().getIdEdu()!= id){
            return new ResponseEntity<>(new Mensaje("Esa educacion ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getTituloEdu())){
            return new ResponseEntity<>(new Mensaje("El titulo es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        
        Educacion edu = eduService.getEdu(id).get();
        edu.setTituloEdu(dtoEdu.getTituloEdu());
        edu.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        edu.setImgEdu(dtoEdu.getImgEdu());
        
        eduService.saveEdu(edu);
        
        return new ResponseEntity<>(new Mensaje("Educacion editada correctamente"),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!eduService.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        eduService.deleteEdu(id);
        
        return new ResponseEntity<>(new Mensaje("Educacion eliminada correctamente"),HttpStatus.OK);
    }
    @GetMapping("/getEdu/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!eduService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduService.getEdu(id).get();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
}
