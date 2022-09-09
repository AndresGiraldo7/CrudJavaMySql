package com.institucion.service;

import com.institucion.domain.Docente;


import java.util.List;
import java.util.Optional;

public interface IDocenteService {

    public List<Docente> listar();

    /**
     * Funcion para guardar usuarios
     * */
    public Docente save(Docente docente);

    /**
     * Funcion para actualizar usuarios
     * */
    public Docente update(Long id, Docente docente);

    /**
     * Funcion para eliminar usuarios
     * */
    public void delete(Docente docente);


    /**
     * Funcion para obtener un registro de la tabla usuarios utilizando el id
     * */
    public Optional<Docente> findUser(Docente docente);

}
