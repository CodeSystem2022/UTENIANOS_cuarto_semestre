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
			case 2 ->{// buscar estudiante por id
				logger.info("Digite el ID del estudiante a buscar:");
				var idEstudiante= Integer.parseInt(consola.nextLine());
				Estudiantes2022 estudiante=estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante!=null){
					logger.info("Estudiante Encontrado: " + estudiante+ nl);
				}else{
					logger.info("Estudiante no encontrado con ese Id"+ estudiante+nl);
				}

			}//fin case 2
			case 3->{ // agregar estudiante
				logger.info("Agregaremos el estudiante: " +nl);
				logger.info("Nombre: ");
				var nombre=consola.nextLine();
				logger.info("Apellido: ");
				var apellido= consola.nextLine();
				logger.info("Telefono: ");
				var telefono= consola.nextLine();
				logger.info("Email: ");
				var email= consola.nextLine();
				//creamos el objeto estudiante sin el id y constructor vacío
				Estudiantes2022 estudiante= new Estudiantes2022();
				//seteamos los datos a nuestro estudiante creado
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				//guardamos el estudiante creado
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado correctamente: "+ estudiante+nl);

			}//fin case 3
			case 4->{//modificar estudiante
				logger.info("MODIFICAR ESTUDIANTE:" + nl);
				logger.info("Ingrese el ID del Estudiante a modificar: ");
				var idEstudiante= Integer.parseInt(consola.nextLine());
				//buscamos el estudiantea modificar
				 Estudiantes2022  estudiante= estudianteServicio.buscarEstudiantePorId(idEstudiante);
				 if (estudiante!=null){//encontro el objeto, por lo tanto no tengo que crearlo
					 logger.info("Nombre: ");
					 var nombre=consola.nextLine();
					 logger.info("Apellido: ");
					 var apellido= consola.nextLine();
					 logger.info("Telefono: ");
					 var telefono= consola.nextLine();
					 logger.info("Email: ");
					 var email= consola.nextLine();
					 //seteamos los nuevos valores
					 estudiante.setNombre(nombre);
					 estudiante.setApellido(apellido);
					 estudiante.setTelefono(telefono);
					 estudiante.setEmail(email);
					 estudianteServicio.guardarEstudiante(estudiante);
					 logger.info("Estudiante Modificado correctamente: " + estudiante+nl);
				 }else{
					 logger.info("Estudiante no encontrado con el ID:" +idEstudiante+nl);
				 }

			}//fin case 4
			case 5->{//eliminar estudiante
				logger.info("Eliminar estudiante " + nl);
				logger.info("Ingrese el id del estudiante a Eliminar:");
				var idEstudiante= Integer.parseInt(consola.nextLine());
				//buscamos el id del estudiante a modificar
				var estudiante= estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante!=null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: " + estudiante+nl);
				}else{
					logger.info("Estudiante no Encontrado con ese ID:" + estudiante+nl);
				}


			}//fin case 5

			case 6->{//salir del sistema
				logger.info("Gracias por utilizar el sistema, hasta pronto..."+nl+nl);
				salir= true;

			}//fin case 6
			default -> logger.info("Opción incorrecta:" + opcion+nl);

		}//fin switch
		return salir;

	}// fin método ejecturarOpciones




	}

