package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

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
		
		
		


		// Estudiantes

		Estudiante estudiante1 = Estudiante.builder()
		.nombre("Martina")
		.primerApellido("Garcia")
		.segundoApellido("Ramirez")
		.fechaMatriculacion(LocalDate.of(2023, Month.APRIL, 24))
		.totalAsignaturas(4)
		.curso(curso1)
		.genero(Genero.OTRO)
		.foto("Foto de Martina")
		.build();

		Estudiante estudiante2 = Estudiante.builder()
		.nombre("Rocio")
		.primerApellido("Perez")
		.segundoApellido("Cruz")
		.fechaMatriculacion(LocalDate.of(2021, Month.JANUARY, 2))
		.totalAsignaturas(6)
		.curso(curso1)
		.genero(Genero.MUJER)
		.foto("Foto de Rocio")
		.build();

		Estudiante estudiante3 = Estudiante.builder()
		.nombre("Luis")
		.primerApellido("Romero")
		.segundoApellido("Moreno")
		.fechaMatriculacion(LocalDate.of(2020, Month.OCTOBER, 18))
		.totalAsignaturas(6)
		.curso(curso2)
		.genero(Genero.HOMBRE)
		.foto("Foto de Luis")
		.build();

		Estudiante estudiante4 = Estudiante.builder()
		.nombre("Martin")
		.primerApellido("Consoli")
		.segundoApellido("Mari")
		.fechaMatriculacion(LocalDate.of(2024, Month.JANUARY, 20))
		.totalAsignaturas(2)
		.curso(curso3)
		.genero(Genero.OTRO)
		.foto("Foto de Martin")
		.build();

		Estudiante estudiante5 = Estudiante.builder()
		.nombre("Laura")
		.primerApellido("Canzani")
		.segundoApellido("Lope")
		.fechaMatriculacion(LocalDate.of(2022, Month.FEBRUARY, 3))
		.totalAsignaturas(4)
		.curso(curso2)
		.genero(Genero.MUJER)
		.foto("Foto de Laura")
		.build();

		Estudiante estudiante6 = Estudiante.builder()
		.nombre("Marco")
		.primerApellido("Cordoba")
		.segundoApellido("Gonzalez")
		.fechaMatriculacion(LocalDate.of(2022, Month.MAY, 2))
		.totalAsignaturas(3)
		.curso(curso3)
		.genero(Genero.HOMBRE)
		.foto("Foto de Marco")
		.build();

			

		// Telefonos

		List<Telefono> telefonosEstudiante1= new ArrayList<>();

		Telefono telefono1Estudiante1 = Telefono.builder()
				.numero("374374657")
				.estudiante(estudiante1)
				.build();
		Telefono telefono2Estudiante1 = Telefono.builder()
				.numero("374738948")
				.estudiante(estudiante1)
				.build();
		
		telefonosEstudiante1.add(telefono1Estudiante1);
		telefonosEstudiante1.add(telefono1Estudiante1);
		
		estudiante1.setTelefonos(telefonosEstudiante1);
		
		List<Telefono> telefonosEstudiante2= new ArrayList<>();
		
		Telefono telefono1Estudiante2 = Telefono.builder()
				.numero("374374657")
				.estudiante(estudiante2)
				.build();
		Telefono telefono2Estudiante2 = Telefono.builder()
				.numero("387293485")
				.estudiante(estudiante2)
				.build();
		
		telefonosEstudiante2.add(telefono1Estudiante2);
		telefonosEstudiante2.add(telefono2Estudiante2);
		
		estudiante2.setTelefonos(telefonosEstudiante2);

		List<Telefono> telefonosEstudiante3= new ArrayList<>();

		Telefono telefono1Estudiante3 = Telefono.builder()
				.numero("746857497")
				.estudiante(estudiante3)
				.build();
		Telefono telefono2Estudiante3 = Telefono.builder()
				.numero("475465746")
				.estudiante(estudiante3)
				.build();

				telefonosEstudiante3.add(telefono1Estudiante3);
				telefonosEstudiante3.add(telefono2Estudiante3);

				estudiante3.setTelefonos(telefonosEstudiante3);

		List<Telefono> telefonosEstudiante4= new ArrayList<>();
		Telefono telefono1Estudiante4 = Telefono.builder()
				.numero("746584756")
				.estudiante(estudiante4)
				.build();
		Telefono telefono2Estudiante4 = Telefono.builder()
				.numero("475648576")
				.estudiante(estudiante4)
				.build();

				telefonosEstudiante4.add(telefono1Estudiante4);
				telefonosEstudiante4.add(telefono2Estudiante4);

				estudiante4.setTelefonos(telefonosEstudiante4);

		// Telefono estudiante 5

		List<Telefono> telefonosEstudiante5= new ArrayList<>();
		Telefono telefono1Estudiante5 = Telefono.builder()
				.numero("746584756")
				.estudiante(estudiante5)
				.build();
		Telefono telefono2Estudiante5 = Telefono.builder()
				.numero("475648576")
				.estudiante(estudiante5)
				.build();

				telefonosEstudiante5.add(telefono1Estudiante5);
				telefonosEstudiante5.add(telefono2Estudiante5);

				estudiante5.setTelefonos(telefonosEstudiante5);

		

		// Telefono estiduante 6

		

		List<Telefono> telefonosEstudiante6= new ArrayList<>();
		Telefono telefono1Estudiante6 = Telefono.builder()
				.numero("746584756")
				.estudiante(estudiante6)
				.build();
		Telefono telefono2Estudiante6 = Telefono.builder()
				.numero("475648576")
				.estudiante(estudiante6)
				.build();

				telefonosEstudiante6.add(telefono1Estudiante6);
				telefonosEstudiante6.add(telefono2Estudiante6);

				estudiante6.setTelefonos(telefonosEstudiante6);

		


		// Correo

		List<Correo> correosEstudiante1= new ArrayList<>();
		Correo Correo1Estudiante1 = Correo.builder()
				.correo("aoruu@gmail.com")
				.estudiante(estudiante1)
				.build();
		Correo Correo2Estudiante1 = Correo.builder()
				.correo("ueijd@gmail.com")
				.estudiante(estudiante2)
				.build();

		correosEstudiante1.add(Correo1Estudiante1);
		correosEstudiante1.add(Correo2Estudiante1);


		List<Correo> correosEstudiante2= new ArrayList<>();
		Correo Correo1Estudiante2 = Correo.builder()
				.correo("iuwehf@gmail.com")
				.estudiante(estudiante3)
				.build();
		Correo Correo2Estudiante2 = Correo.builder()
				.correo("sdjhdf@gmail.com")
				.estudiante(estudiante4)
				.build();

		correosEstudiante2.add(Correo1Estudiante2);
		correosEstudiante2.add(Correo2Estudiante2);

		List<Correo> correosEstudiante3= new ArrayList<>();
		Correo Correo1Estudiante3 = Correo.builder()
				.correo("uejdi@gmail.com")
				.estudiante(estudiante5)
				.build();

		Correo Correo2Estudiante3 = Correo.builder()
				.correo("jsfgc@gmail.com")
				.estudiante(estudiante6)
				.build();


		correosEstudiante3.add(Correo1Estudiante3);
		correosEstudiante3.add(Correo2Estudiante3);
		

		estudiante1.setCorreos(correosEstudiante1);
		estudiante2.setCorreos(correosEstudiante2);
		estudiante3.setCorreos(correosEstudiante3);
		estudiante4.setCorreos(correosEstudiante1);
		estudiante5.setCorreos(correosEstudiante2);
		estudiante6.setCorreos(correosEstudiante3);
		
		
		estudianteService.persistirEstudiante(estudiante1);
		estudianteService.persistirEstudiante(estudiante2);
		estudianteService.persistirEstudiante(estudiante3);
		estudianteService.persistirEstudiante(estudiante4);
		estudianteService.persistirEstudiante(estudiante5);
		estudianteService.persistirEstudiante(estudiante6);
	}
}
