package com.institucion.controller;


import com.institucion.domain.Docente;
import com.institucion.service.DocenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class DocenteController {


    @Autowired
    private DocenteService docenteService;

    @GetMapping(path = "/api/docentes")
    public List<Docente> listado(){
        var docentes = docenteService.listar();
        return docentes;
    }

    @PostMapping(path ="/api/docentes")
    public ResponseEntity<Docente> crear(@RequestBody Docente docente){
        log.info("Docente a crear: {}", docente);
        docenteService.save(docente);
        return new ResponseEntity<>(docente, HttpStatus.CREATED);

    }

    @DeleteMapping(path ="/api/docentes/{id}")
    public ResponseEntity <Docente> borrar(Docente docente){
        log.info("Docente a borrar: {}", docente);
        docenteService.delete(docente);
        return new ResponseEntity<>(docente, HttpStatus.OK);
    }

    @PutMapping(path ="/api/docentes/{id}")
    public ResponseEntity <Docente> actualizar(@RequestBody  Docente docente, @PathVariable("id") Long id){
        log.info("Docente a modificar: {}", docente);
        docenteService.update(id, docente);
        return new ResponseEntity<>(docente, HttpStatus.OK);
    }
}
