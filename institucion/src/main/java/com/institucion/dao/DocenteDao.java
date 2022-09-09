package com.institucion.dao;

import com.institucion.domain.Docente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DocenteDao extends CrudRepository<Docente, Long>{


}
