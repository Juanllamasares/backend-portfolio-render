package com.portfolio.jell.controller;

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

import com.portfolio.jell.dto.DtoProyectos;
import com.portfolio.jell.entity.Proyectos;
import com.portfolio.jell.security.controller.Mensaje;
import com.portfolio.jell.service.ProyectoService;

@RestController
@RequestMapping("/proyects")

public class ProyectosController {
    @Autowired 
    private ProyectoService proyectServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyectos>> listProyects(){
        List<Proyectos> listProyects = proyectServ.getListProyects();
        return new ResponseEntity<>(listProyects,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyect){
        if(StringUtils.isBlank(dtoProyect.getTituloProyect())){
            return new ResponseEntity<>(new Mensaje("Titulo del proyecto es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        if(proyectServ.existsByTituloProyect(dtoProyect.getTituloProyect())){
            return new ResponseEntity<>(new Mensaje("Ese titulo del proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        Proyectos proyect = new Proyectos(dtoProyect.getTituloProyect(),dtoProyect.getUrlProyecto(),dtoProyect.getDescripcionProyect(),dtoProyect.getImgProyect());
        proyectServ.saveProyect(proyect);
        
        return new ResponseEntity<>(new Mensaje("Proyecto creado con exito"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody DtoProyectos dtoProyect){
        if(!proyectServ.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        if(proyectServ.existsByTituloProyect(dtoProyect.getTituloProyect()) && proyectServ.getByTituloProyect(dtoProyect.getTituloProyect()).get().getIdProy()!= id){
            return new ResponseEntity<>(new Mensaje("Ese proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProyect.getTituloProyect())){
            return new ResponseEntity<>(new Mensaje("El titulo es OBLIGATORIO"),HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyect = proyectServ.getProyect(id).get();
        proyect.setTituloProyect(dtoProyect.getTituloProyect());
        proyect.setUrlProyecto(dtoProyect.getUrlProyecto());
        proyect.setDescripcionProyect(dtoProyect.getDescripcionProyect());
        proyect.setImgProyect(dtoProyect.getImgProyect());
        
        proyectServ.saveProyect(proyect);
        
        return new ResponseEntity<>(new Mensaje("Proyecto editado correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectServ.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        proyectServ.deleteProyect(id);
        
        return new ResponseEntity<>(new Mensaje("Proyecto eliminado correctamente"),HttpStatus.OK);
    }
    
    @GetMapping("/getProyect/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!proyectServ.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyect = proyectServ.getProyect(id).get();
        return new ResponseEntity<>(proyect, HttpStatus.OK);
    }
}
