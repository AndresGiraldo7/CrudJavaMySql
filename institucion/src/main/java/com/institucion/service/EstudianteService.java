package com.institucion.service;

import com.institucion.dao.EstudianteDao;
import com.institucion.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteService implements  IEstudianteService{

    @Autowired
    public EstudianteDao estudianteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listar() {
        return (List<Estudiante> )estudianteDao.findAll();
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public Estudiante update(Long id, Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
    estudianteDao.delete(estudiante);
    }

    @Override
    @Transactional
    public Optional<Estudiante> findUser(Estudiante estudiante) {
        return Optional.empty();
    }


}
