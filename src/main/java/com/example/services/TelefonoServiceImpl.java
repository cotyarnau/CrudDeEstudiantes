package com.example.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.dao.EstudianteDao;
import com.example.dao.TelefonoDao;
import com.example.entities.Telefono;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
 
public class TelefonoServiceImpl implements TelefonoService{
    
    // El TelefonoDao porque es allí donde cree el bean con repository
    private final TelefonoDao telefonoDao;
 
    private final EstudianteDao estudianteDao;
  
    @Override
    public List<Telefono> telefonos(int idEstudiante) {
        return telefonoDao.findByEstudiante(estudianteDao.findById(idEstudiante).get());
    }
 
   
 
    @Override
    public void persistirTelefono(int idEstudiante, Telefono telefono) {
        telefono.setEstudiante(estudianteDao.findById(idEstudiante).get());
        telefonoDao.save(telefono);
    }
 
}
 

