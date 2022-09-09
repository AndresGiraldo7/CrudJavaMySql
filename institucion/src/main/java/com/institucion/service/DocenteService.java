package com.institucion.service;

import com.institucion.dao.DocenteDao;
import com.institucion.dao.EstudianteDao;
import com.institucion.domain.Docente;
import com.institucion.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService implements  IDocenteService {
    @Autowired
    public DocenteDao docenteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Docente> listar() {
        return (List<Docente> )docenteDao.findAll();
    }

    @Override
    public Docente save(Docente docente) {
        return docenteDao.save(docente);
    }

    @Override
    public Docente update(Long id, Docente docente) {
        docente.setId(id);
        return docenteDao.save(docente);
    }

    @Override
    public void delete(Docente docente) {
       docenteDao.delete(docente);
    }

    @Override
    public Optional<Docente> findUser(Docente docente) {
        return Optional.empty();
    }



}
