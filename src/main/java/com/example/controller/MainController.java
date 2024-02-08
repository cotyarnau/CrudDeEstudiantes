package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import java.util.stream.Collectors;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Correo;
import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Horario;
import com.example.entities.Telefono;
import com.example.services.CursoService;
import com.example.services.EstudianteService;


import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    private final Logger LOG = Logger.getLogger("MainController");

    

    @GetMapping("/estudiantes")
    public String dameEmpleados(Model model) {

        model.addAttribute("estudiantes", estudianteService.dameTodosLosEstudiantes());
        return "views/listadoEstudiantes";

    }
    
    @GetMapping("/detalles/{id}")
    public String detallesEstudiante(@PathVariable(name = "id") int idEstudiante, Model model) {
        LOG.info("ID Estudiante Recibido" + idEstudiante);
        model.addAttribute("estudiante", estudianteService.dameunEstudiante(idEstudiante));

        List<Curso> cursos = cursoService.dameCursos();
        model.addAttribute("cursos", cursos);

        Estudiante estudiante = new Estudiante();
        if (estudiante.getTelefonos() != null) {
            String numerosTelefono = estudiante.getTelefonos().stream().map(Telefono::getNumero)
                    .collect(Collectors.joining(";"));
            model.addAttribute("numerosTelefono", numerosTelefono);
        }

        // Obtengo los correos

        if (estudiante.getCorreos() != null) {
            String direccionesDeCorreo = estudiante.getCorreos().stream().map(Correo::getCorreo)
                    .collect(Collectors.joining(";"));
            model.addAttribute("direccionesDeCorreo", direccionesDeCorreo);
        }
        return "views/estudianteDetalles";
    }

    @GetMapping("/turnodiurno")
    public String estudiantesDiurno(Model model) {
       
        List<Estudiante> estudiantesDiurnos = estudianteService.dameTodosLosEstudiantes().stream().filter(estudiante -> estudiante.getCurso().getHorario() == Horario.DIURNO).toList();
        model.addAttribute("estudiantesDiurnos", estudiantesDiurnos);

        return "views/estudianteTurnoDiurno";
    }

    @GetMapping("/turnonocturno")
    public String estudiantesNocturno(Model model) {
       
        List<Estudiante> estudiantesNocturnos = estudianteService.dameTodosLosEstudiantes().stream().filter(estudiante -> estudiante.getCurso().getHorario() == Horario.NOCTURNO).toList();
        model.addAttribute("estudiantesNocturnos", estudiantesNocturnos);

        return "views/estudianteTurnoNocturno";
    }

    @GetMapping("/estudiantesporcurso")
    public String estudiantesPorCurso(Model model) {
       
        Map<Curso ,List<Estudiante>> estudiantesPorCurso = estudianteService.dameTodosLosEstudiantes().stream().collect(Collectors.groupingBy(Estudiante::getCurso));
        model.addAttribute("estudiantesPorCurso", estudiantesPorCurso);

        return "views/estudiantePorCurso";
    }
    @GetMapping("/frmAltaModificacion")
    public String formularioAltaModificacionEstudiante(Model model) {
        // Al Modelo le paso un objeto empleado vacio
        Estudiante estudiante = new Estudiante();

        model.addAttribute("estudiante", estudiante);

        // Tambien los cursos

        model.addAttribute("cursos", cursoService.dameCursos());

        return "views/frmAltaModificacionEstudiante";

    }

    @PostMapping("/persistir")
    @Transactional
    public String persistirEstudiante(@ModelAttribute(name = "estudiante") Estudiante estudiante,
            @RequestParam(name = "numerosTel", required = false) String telefonosRecibidos,
            @RequestParam(name = "direccionesCorreo", required = false) String correosRecibidos) {

        // Procesar los telefonos
        if (telefonosRecibidos != null) {
            String[] arrayTelefonos = telefonosRecibidos.split(";");
            List<String> numerosTelefonos = Arrays.asList(arrayTelefonos);

            List<Telefono> telefonos = new ArrayList<>();
            numerosTelefonos.stream().forEach(numeroTelefono -> {
                telefonos.add(
                        Telefono.builder()
                                .numero(numeroTelefono)
                                .estudiante(estudiante)
                                .build());
            });
            estudiante.setTelefonos(telefonos);
        }
        // Procesar los correos
        if (correosRecibidos != null) {
            String[] arrayCorreos = correosRecibidos.split(";");
            List<String> direccionesDeCorreo = Arrays.asList(arrayCorreos);

            List<Correo> correos = new ArrayList<>();
            direccionesDeCorreo.stream().forEach(direccionDeCorreo -> {
                correos.add(
                        Correo.builder()
                                .correo(direccionDeCorreo)
                                .estudiante(estudiante)
                                .build());
            });
            estudiante.setCorreos(correos);

        }
        estudianteService.persistirEstudiante(estudiante);
        return "redirect:/estudiantes";

    }

    @GetMapping("/actualizar/{id}")
    @Transactional
    public String actualizarEstudiante(@PathVariable(name = "id", required = true) int idEstudiante, Model model) {
        // Recupera el empleado cuyo id se recibe como parametro
        Estudiante estudiante = estudianteService.dameunEstudiante(idEstudiante);
        model.addAttribute("estudiante", estudiante);
        // Recupero los cursos
        List<Curso> cursos = cursoService.dameCursos();
        model.addAttribute("cursos", cursos);

        // Obtengo los numeros de telefono (separados por ;) para que aparezcan en el
        // formulario
        // no necesito recupararlos porque ya se propagan los cambios por cascada

        if (estudiante.getTelefonos() != null) {
            String numerosTelefono = estudiante.getTelefonos().stream().map(Telefono::getNumero)
                    .collect(Collectors.joining(";"));
            model.addAttribute("numerosTelefono", numerosTelefono);
        }

        // Obtengo los correos

        if (estudiante.getCorreos() != null) {
            String direccionesDeCorreo = estudiante.getCorreos().stream().map(Correo::getCorreo)
                    .collect(Collectors.joining(";"));
            model.addAttribute("direccionesDeCorreo", direccionesDeCorreo);
        }
        return "views/frmAltaModificacionEstudiante";

    }

    @GetMapping("/eliminar/{id}")
    @Transactional
    public String eliminarEstudiante(@PathVariable(name = "id", required = true) int idEstudiante) {
        estudianteService.eliminarEstudiante(idEstudiante);

        return "redirect:/estudiantes";

    }
}

