package com.institucion.controller;


import com.institucion.domain.Estudiante;
import com.institucion.service.EstudianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@RestController
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @GetMapping(path = "/api/estudiantes")
    public List<Estudiante> listado(){
        var estudiante = estudianteService.listar();
        return estudiante;
    }

    @PostMapping(path = "/api/estudiantes")
    public ResponseEntity <Estudiante>crear(@RequestBody Estudiante estudiante){
        log.info("Estudiante a crear: {}", estudiante);
        estudianteService.save(estudiante);
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/api/estudiantes/{id}")
    public ResponseEntity <Estudiante> borrar(Estudiante estudiante){
        log.info("Estudiante a borrar: {}", estudiante);
        estudianteService.delete(estudiante);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PutMapping(path = "/api/estudiantes/{id}")
    public ResponseEntity <Estudiante> actualizar(@RequestBody  Estudiante estudiante, @PathVariable("id") Long id){
        log.info("Estudiante a modificar: {}", estudiante);
        estudianteService.update(id, estudiante);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }


}
