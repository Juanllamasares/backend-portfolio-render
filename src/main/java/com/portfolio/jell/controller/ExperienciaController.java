package com.portfolio.jell.controller;

import com.portfolio.jell.dto.DtoExperiencia;
import com.portfolio.jell.entity.Experiencia;
import com.portfolio.jell.security.controller.Mensaje;
import com.portfolio.jell.service.ExperienciaService;
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
@RequestMapping("/exp")
public class ExperienciaController {
    @Autowired
    private ExperienciaService expService;

    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> listExp() {
        List<Experiencia> listExp = expService.getListExp();
        return new ResponseEntity<>(listExp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getTituloExp())) {
            return new ResponseEntity<>(new Mensaje("Titulo de la experiencia es OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        }
        if (expService.existsByTituloExp(dtoExp.getTituloExp())) {
            return new ResponseEntity<>(new Mensaje("Ese titulo de experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia exp = new Experiencia(dtoExp.getTituloExp(), dtoExp.getDescripcionExp(), dtoExp.getImgExp());
        expService.saveExp(exp);

        return new ResponseEntity<>(new Mensaje("Experiencia creada con exito"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp) {
        if (!expService.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (expService.existsByTituloExp(dtoExp.getTituloExp())
                && expService.getByTituloExp(dtoExp.getTituloExp()).get().getIdExp() != id) {
            return new ResponseEntity<>(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getTituloExp())) {
            return new ResponseEntity<>(new Mensaje("El titulo es OBLIGATORIO"), HttpStatus.BAD_REQUEST);
        }

        Experiencia exp = expService.getExp(id).get();
        exp.setTituloExp(dtoExp.getTituloExp());
        exp.setDescripcionExp(dtoExp.getDescripcionExp());
        exp.setImgExp(dtoExp.getImgExp());

        expService.saveExp(exp);

        return new ResponseEntity<>(new Mensaje("Experiencia editada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expService.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        expService.deleteExp(id);

        return new ResponseEntity<>(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }

    @GetMapping("/getExp/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!expService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expService.getExp(id).get();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
}
