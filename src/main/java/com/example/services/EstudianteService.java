package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;

public interface EstudianteService {

    public List<Estudiante> dameTodosLosEstudiantes(); 
    public Estudiante dameunEstudiante(int idEstudiante); 
    public void eliminarEstudiante(int idEstudiante);
    public void persistirEstudiante(Estudiante estudiante);
    public void actualizarEstudiante(Estudiante estudiante);
}
