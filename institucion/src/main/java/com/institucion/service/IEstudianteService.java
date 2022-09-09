package com.institucion.service;

import com.institucion.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {
    public List<Estudiante> listar();

    /**
     * Funcion para guardar usuarios
     * */
    public Estudiante save(Estudiante estudiante);

    /**
     * Funcion para actualizar usuarios
     * */
    public Estudiante update(Long id, Estudiante estudiante);

    /**
     * Funcion para eliminar usuarios
     * */
    public void delete(Estudiante estudiante);


    /**
     * Funcion para obtener un registro de la tabla usuarios utilizando el id
     * */
    public Optional<Estudiante> findUser(Estudiante estudiante);

}
