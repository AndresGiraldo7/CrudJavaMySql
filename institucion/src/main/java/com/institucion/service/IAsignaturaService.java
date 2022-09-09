package com.institucion.service;

import com.institucion.domain.Asignatura;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface IAsignaturaService {


    public List<Asignatura> listar();

    /**
     * Funcion para guardar usuarios
     * */
    public Asignatura save(Asignatura asignatura);

    /**
     * Funcion para actualizar usuarios
     * */
    public Asignatura update(Long id, Asignatura asignatura);

    /**
     * Funcion para eliminar usuarios
     * */
    public void delete(Asignatura asignatura);


    /**
     * Funcion para obtener un registro de la tabla usuarios utilizando el id
     * */
    public Optional<Asignatura> findUser(Asignatura asignatura);


}
