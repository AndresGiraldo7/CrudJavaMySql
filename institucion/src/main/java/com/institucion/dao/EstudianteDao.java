package com.institucion.dao;

import com.institucion.domain.Estudiante;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EstudianteDao extends CrudRepository<Estudiante, Long> {


}