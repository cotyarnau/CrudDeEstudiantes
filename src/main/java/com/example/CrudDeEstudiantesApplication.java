package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.entities.Correo;
import com.example.entities.Curso;
import com.example.entities.Estudiante;
import com.example.entities.Genero;
import com.example.entities.Horario;
import com.example.entities.Telefono;
import com.example.services.CorreoService;
import com.example.services.CursoService;
import com.example.services.EstudianteService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class CrudDeEstudiantesApplication implements CommandLineRunner {

	private final EstudianteService estudianteService;
	private final CursoService cursoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(CrudDeEstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Primero creamos cursos
		

		
		Curso curso1 = Curso.builder()
				.nombre("Literatura")
				.descripcion("lectura de novelas clasicas")
				.horario(Horario.NOCTURNO)
				.build();

		Curso curso2 = Curso.builder()
				.nombre("Historia")
				.descripcion("historia de la humanidad")
				.horario(Horario.DIURNO)
				.build();

		Curso curso3 = Curso.builder()
				.nombre("Biologia")
				.descripcion("estudio de plantas y animales")
				.horario(Horario.NOCTURNO)
				.build();
		

		cursoService.persistirCurso(curso1);
		cursoService.persistirCurso(curso2);
		cursoService.persistirCurso(curso3);
		


		// Estudiantes

		Estudiante estudiante1 = Estudiante.builder()
		.nombre("Martina")
		.primerApellido("Garcia")
		.segundoApellido("Ramirez")
		.fechaMatriculacion(LocalDate.of(2023, Month.APRIL, 24))
		.totalAsignaturas(4)
		.curso(cursoService.dameunCurso(1))
		.genero(Genero.OTRO)
		.foto("Foto de Martina")
		.build();

		Estudiante estudiante2 = Estudiante.builder()
		.nombre("Rocio")
		.primerApellido("Perez")
		.segundoApellido("Cruz")
		.fechaMatriculacion(LocalDate.of(2021, Month.JANUARY, 2))
		.totalAsignaturas(6)
		.curso(cursoService.dameunCurso(1))
		.genero(Genero.MUJER)
		.foto("Foto de Rocio")
		.build();

		Estudiante estudiante3 = Estudiante.builder()
		.nombre("Luis")
		.primerApellido("Romero")
		.segundoApellido("Moreno")
		.fechaMatriculacion(LocalDate.of(2020, Month.OCTOBER, 18))
		.totalAsignaturas(6)
		.curso(cursoService.dameunCurso(2))
		.genero(Genero.HOMBRE)
		.foto("Foto de Luis")
		.build();

		Estudiante estudiante4 = Estudiante.builder()
		.nombre("Martin")
		.primerApellido("Consoli")
		.segundoApellido("Mari")
		.fechaMatriculacion(LocalDate.of(2024, Month.JANUARY, 20))
		.totalAsignaturas(2)
		.curso(cursoService.dameunCurso(2))
		.genero(Genero.OTRO)
		.foto("Foto de Martin")
		.build();

		Estudiante estudiante5 = Estudiante.builder()
		.nombre("Laura")
		.primerApellido("Canzani")
		.segundoApellido("Lope")
		.fechaMatriculacion(LocalDate.of(2022, Month.FEBRUARY, 3))
		.totalAsignaturas(4)
		.curso(cursoService.dameunCurso(3))
		.genero(Genero.MUJER)
		.foto("Foto de Laura")
		.build();

		Estudiante estudiante6 = Estudiante.builder()
		.nombre("Marco")
		.primerApellido("Cordoba")
		.segundoApellido("Gonzalez")
		.fechaMatriculacion(LocalDate.of(2022, Month.MAY, 2))
		.totalAsignaturas(3)
		.curso(cursoService.dameunCurso(3))
		.genero(Genero.HOMBRE)
		.foto("Foto de Marco")
		.build();

		estudianteService.persistirEstudiante(estudiante1);
		estudianteService.persistirEstudiante(estudiante2);
		estudianteService.persistirEstudiante(estudiante3);
		estudianteService.persistirEstudiante(estudiante4);
		estudianteService.persistirEstudiante(estudiante5);
		estudianteService.persistirEstudiante(estudiante6);
		

		// Telefonos

		
		Telefono telefono1Estudiante1 = Telefono.builder()
				.numero("374374657")
				.build();
		Telefono telefono2Estudiante1 = Telefono.builder()
				.numero("374738948")
				.build();
		

		telefonoService.persistirTelefono(1, telefono1Estudiante1);
		telefonoService.persistirTelefono(1, telefono2Estudiante1);
		
		Telefono telefono1Estudiante2 = Telefono.builder()
				.numero("374374657")
				.build();
		Telefono telefono2Estudiante2 = Telefono.builder()
				.numero("387293485")
				.build();

		telefonoService.persistirTelefono(2, telefono1Estudiante2);
		telefonoService.persistirTelefono(2, telefono2Estudiante2);

		Telefono telefono1Estudiante3 = Telefono.builder()
				.numero("746857497")
				.build();
		Telefono telefono2Estudiante3 = Telefono.builder()
				.numero("475465746")
				.build();

		telefonoService.persistirTelefono(3, telefono1Estudiante3);
		telefonoService.persistirTelefono(3, telefono2Estudiante3);

		Telefono telefono1Estudiante4 = Telefono.builder()
				.numero("746584756")
				.build();
		Telefono telefono2Estudiante4 = Telefono.builder()
				.numero("475648576")
				.build();

		telefonoService.persistirTelefono(4, telefono1Estudiante4);
		telefonoService.persistirTelefono(4, telefono2Estudiante4);

		// Telefono estiduante 5

		telefonoService.persistirTelefono(5, telefono1Estudiante1);
		telefonoService.persistirTelefono(5, telefono2Estudiante3);

		// Telefono estiduante 6

		telefonoService.persistirTelefono(6, telefono1Estudiante4);
		telefonoService.persistirTelefono(6, telefono2Estudiante2);


		// Correo

		
		Correo Correo1Estudiante1 = Correo.builder()
				.correo("aoruu@gmail.com")
				.build();
		Correo Correo2Estudiante1 = Correo.builder()
				.correo("ueijd@gmail.com")
				.build();

		Correo Correo1Estudiante2 = Correo.builder()
				.correo("iuwehf@gmail.com")
				.build();
		Correo Correo2Estudiante2 = Correo.builder()
				.correo("sdjhdf@gmail.com")
				.build();

		Correo correo3 = Correo.builder()
				.correo("uejdi@gmail.com")
				.build();

		Correo correo4 = Correo.builder()
				.correo("jsfgc@gmail.com")
				.build();


		correoService.persistirCorreos(1, correo4);
		correoService.persistirCorreos(2, Correo1Estudiante2);
		correoService.persistirCorreos(2, Correo2Estudiante1);
		correoService.persistirCorreos(3, Correo1Estudiante2);
		correoService.persistirCorreos(4, correo3);
		correoService.persistirCorreos(5, Correo1Estudiante1);
		correoService.persistirCorreos(6, Correo2Estudiante2);

		
		
		
	}
}
