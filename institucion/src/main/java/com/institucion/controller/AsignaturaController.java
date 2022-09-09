package com.institucion.controller;

import com.institucion.domain.Asignatura;
import com.institucion.service.AsignaturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;


    @GetMapping(path = "/api/asignaturas")
    public List<Asignatura> listado(){
        var asignatura = asignaturaService.listar();
        return asignatura;

    }


    @PostMapping(path ="/api/asignaturas")
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura){
        log.info("asignatura a crear: {}", asignatura);
        asignaturaService.save(asignatura);
        return new ResponseEntity<>(asignatura, HttpStatus.CREATED);

    }

    @DeleteMapping(path ="/api/asignaturas/{id}")
    public ResponseEntity <Asignatura> borrar(Asignatura asignatura){
        log.info("asignatura a borrar: {}", asignatura);
        asignaturaService.delete(asignatura);
        return new ResponseEntity<>(asignatura, HttpStatus.OK);
    }
    @PutMapping(path ="/api/asignaturas/{id}")
    public ResponseEntity <Asignatura> actualizar(@RequestBody  Asignatura asignatura, @PathVariable("id") Long id){
        log.info("asignatura a modificar: {}", asignatura);
        asignaturaService.update(id, asignatura);
        return new ResponseEntity<>(asignatura, HttpStatus.OK);
    }
}
