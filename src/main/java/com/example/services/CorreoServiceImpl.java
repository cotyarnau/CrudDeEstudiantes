package com.example.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.dao.CorreoDao;
import com.example.dao.EstudianteDao;
import com.example.entities.Correo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Service

public class CorreoServiceImpl implements CorreoService {
    
    private final CorreoDao correoDao;
    private final EstudianteDao estudianteDao;
    
    @Override
    public List<Correo> dameCorreos(int idEstudiante) {
        return correoDao.findByEstudiante(estudianteDao.findById(idEstudiante).get());
        
    }

  
    @Override
    public void persistirCorreos(int idEstudiante, Correo correo) {
        correo.setEstudiante(estudianteDao.findById(idEstudiante).get());
        correoDao.save(correo);
    }

}

