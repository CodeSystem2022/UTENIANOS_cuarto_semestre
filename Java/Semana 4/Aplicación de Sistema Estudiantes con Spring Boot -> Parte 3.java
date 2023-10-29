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
				//SABA JUAN AGUSTÍN
			case 2: //Buscar estudiante por id
		                logger.info("Digite el id del estudiante a buscar: ");
		                var idEstudiante = Integer.parseInt(consola.nextLine());
		                Estudiantes2022 estudiante = estudianteServicio.buscarEtudiantePorId(idEstudiante);
		                if(estudiante != null){
		                    logger.info("Estudiante encontrado: "+estudiante + nl);
		                }else{
		                    logger.info("Estudiante NO encontrado: "+estudiante + nl);
		                }break;
		        case 3: //Agregar estudiante
		                logger.info("Agregar estudiante: "+ nl);
		                logger.info("Nombre: ");
		                var nombre = consola.nextLine();
		                logger.info("Apellido: ");
		                var apellido = consola.nextLine();
		                logger.info("Teléfono: ");
		                var telefono = consola.nextLine();
		                logger.info("Email: ");
		                var email = consola.nextLine();
		                //Crear el objeto estudiante sin el id
		                var estudiante = new Estudiantes2022();
		                estudiante.setNombre(nombre);
		                estudiante.setApellido(apellido);
		                estudiante.setTelefono(telefono);
		                estudiante.setEmail(email);
		                estudianteServicio.guardarEstudiante(estudiante);
		                logger.info("Estudiante agregado: "+estudiante+ nl);
		                break;
		        case 4: //Modificar estudiante
		                logger.info("Modificar estudiante: "+ nl);
		                logger.info("Ingrese el id del estudiante a modificar: "+ nl);
		                var idEstudiante = Integer.parseInt(consolola.nextLine());
		                // buscamos el estudiante a modificar
		                Estudiantes2022 estudiante = estudianteServicio.buscarEtudiantePorId(idEstudiante);
		                if(estudiante != null){
		                    logger.info("Nombre: ");
		                    var nombre = consola.nextLine();
		                    logger.info("Apellido: ");
		                    var apellido = consola.nextLine();
		                    logger.info("Teléfono: ");
		                    var telefono = consola.nextLine();
		                    logger.info("Email: ");
		                    var email = consola.nextLine(); 
		                    estudiante.setNombre(nombre);
		                    estudiante.setApellido(apellido);
		                    estudiante.setTelefono(telefono);
		                    estudiante.setEmail(email);
		                    estudianteServicio.guardarEstudiante(estudiante);
		                    logger.info("Estudiante modificado: "+estudiante+nl);
		                }else{
		                    logger.info("Estudiante NO encontrado con el id "+estudiante+nl);
		                }
		                break;
		        case 5: //Eliminar estudiante
		                logger.info("Eliminar estudiante: "+ nl);
		                logger.info("Digite el id del Estudiante a eliminar: ");
		                var idEstudiante = Integer.parseInt(consola.nextLine());
		                //buscamos el id del estudiante a eliminar
		                var estudiante = estudianteServicio.buscarEtudiantePorId(idEstudiante);
		                if(estudiante != null){
		                    estudianteServicio.eliminarEstudiante(estudiante);
		                    logger.info("Estudiante eliminado: "+estudiante+nl);
		                    
		                }else{
		                    logger.info("Estudiante NO encontrado con id: "+estudiante+nl);
		                }
		                break;
		        case 6: //Salir
		                logger.info("Hasta pronto!"+nl+nl);
		                salir = true;
		                break;
		        default:
		                logger.info("Opción no reconocida: "+opcion+nl);
		        }
		
		        return salir;
		    }
    

}
