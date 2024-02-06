package com.example.services;

import java.util.List;

import com.example.entities.Curso;

public interface CursoService {

    public List<Curso> dameCursos();
    public Curso dameunCurso(int idCurso);
    public void persistirCurso(Curso curso);
}
