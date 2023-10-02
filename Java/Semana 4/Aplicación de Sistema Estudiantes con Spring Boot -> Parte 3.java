package utn.estudiantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;
	private static final Logger logger= LoggerFactory.getLogger(EstudiantesApplication.class);
	String nl= System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación Estudiante....");
		//Levantar la fabrica de srping
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada....");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl+"Ejecutando el método rum de spring...."+nl);
		var salir= false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir= ejecutarOpciones(consola);
			logger.info(nl);
		}//fin ciclo while
	}

	private void mostrarMenu(){
		//logger.info(nl);
		logger.info("""
                ******SISTEMA ESTUDIANTE*******
                 1) LISTAR ESTUDIANTES
                 2) BUSCAR ESTUDIANTE
                 3) AGREGAR ESTUDIANTE
                 4) MODIFICAR ESTUDIANTE
                 5) ELIMINAR ESTUDIANTE
                 6) SALIR
                 Digite la opción deseada:""");

	}//fin metodo mostrar menu
	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir= false;
		switch (opcion){
			case 1->{// listar estudiante
				logger.info(nl+"Listado de estudiantes: "+ nl);
				List<Estudiantes2022> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante-> logger.info(estudiante.toString()+nl)));

			}
