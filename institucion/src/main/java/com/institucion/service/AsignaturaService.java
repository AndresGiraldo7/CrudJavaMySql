package com.institucion.service;

import com.institucion.dao.AsignaturaDao;
import com.institucion.domain.Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService implements  IAsignaturaService{

    @Autowired
    public AsignaturaDao asignaturaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> listar() {
        return (List<Asignatura>) asignaturaDao.findAll();
    }

    @Override
    @Transactional
    public Asignatura save(Asignatura asignatura) {
        return asignaturaDao.save(asignatura);
    }

    @Override
    @Transactional
    public Asignatura update(Long id, Asignatura asignatura) {
        asignatura.setId(id);
        return asignaturaDao.save(asignatura);
    }

    @Override
    @Transactional
    public void delete(Asignatura asignatura) {
        asignaturaDao.delete(asignatura);
    }

    @Override
    @Transactional
    public Optional<Asignatura> findUser(Asignatura asignatura) {
        return asignaturaDao.findById(asignatura.getId());
    }





}
