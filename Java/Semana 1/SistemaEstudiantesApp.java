package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SistemaEstudiantesApp {
    public static void main(String[] args) {
//        var conexion = Conexion.getConnection();
//
//        if (conexion != null){
//            System.out.println("Conexión exitosa: "+conexion);
//        }else{
//            System.out.println("Hubo un error en la conexión");
//        }
    
    var salir = false;
    var consola = new Scanner(System.in);
    //Se crea una instancia de la clase servicio, esto lo hacemos fuera del ciclo
    var estudianteDao = new EstudianteDAO(); //Esta instancia debe hacerse una vez
    while (!salir){
        try{
            mostrarMenu(); 
            salir = ejecutarOpciones(consola, estudianteDao); //Este será el método que devolverá un booleano
        }catch(Exception e){
            System.out.println("Ocurrió un error al ejecutar la operación: "+e.getMessage());
        }
    }//Fin while
    }//Fin main
    
    private static void mostrarMenu(){
        System.out.println("***** Sistema de Estudiantes *****\n" +
            "1. Listar Estudiantes\n" +
            "2. Buscar Estudiantes\n" +
            "3. Agregar Estudiantes\n" +
            "4. Modificar Estudiantes\n" +
            "5. Eliminar Estudiantes\n" +
            "6. Salir\n" +
            "Digite la opción deseada: ");
    }
    
    /*Método para ejecutar las opciones del Menú. Va a regresar un booleano, ya que es el método que puede modificar el valor de la
    variable salir. Si la variable salir se transforma en Verdadera, se termina el ciclo while. Es decir, si devuelve en false el 
    while se va a seguir ejecutando. Cuando devuelva un true se termina.
    */
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDao){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch(opcion){
            case 1: //Listar Estudiantes
                System.out.println("Listado de Estudiantes");
                var estudiantes = estudianteDao.listarEstudiantes(); //Esta variable recibe el listado de estudiantes
                //Vamos a iterar cada objeto de tipo Estudiante
                estudiantes.forEach(System.out::println);
                break;
            case 2: //Buscar Estudiantes
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDao.buscarEstudiantesPorId(estudiante);
                if (encontrado)
                    System.out.println("Estudiante encontrado: "+estudiante);
                else
                    System.out.println("Estudiante no encontrado: "+estudiante);
                break;
            case 3: //Agregar Estudiantes
                System.out.println("Agregar estudiante:");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //creamos un objeto de tipo Estudiante pero sin ID
                estudiante = new Estudiante(nombre, apellido, telefono, email);                             //VAR
                var agregado = estudianteDao.agregarEstudiante(estudiante);
                if (agregado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante no agregado: "+estudiante);
                break;
            case 4: //Modificar Estudiantes
                System.out.println("Modificar estudiante");
                //Aquí lo primero es especificar cuál es el id del objeto a modificar
                System.out.println("Ingrese el ID del estudiante a modificar: ");
                idEstudiante = Integer.parseInt(consola.nextLine());                                        //VAR
                System.out.println("Nombre: ");
                nombre = consola.nextLine();                                                                //VAR
                System.out.println("Apellido: ");
                apellido = consola.nextLine();                                                              //VAR
                System.out.println("Telefono: ");
                telefono = consola.nextLine();                                                              //VAR
                System.out.println("Email: ");
                email = consola.nextLine();                                                                 //VAR
                //Creamos el objeto estudiante a modificar
                estudiante = new Estudiante(nombre, apellido, telefono, email);                             //VAR
                var modificado = estudianteDao.modificarEstudiante(estudiante);
                if (modificado)
                    System.out.println("Estudiante modificado: "+estudiante);
                else
                    System.out.println("Estudiante no modificado: "+estudiante);
                break;
            case 5: //Eliminar Estudiantes
                System.out.println("Eliminar estudiante: ");
                System.out.println("Ingrese el ID del Estudiante a eliminar: ");
                idEstudiante = Integer.parseInt(consola.nextLine());                                        //VAR
                estudiante = new Estudiante(idEstudiante);                                                  //VAR
                var eliminado = estudianteDao.eliminarEstudiante(estudiante);
                if (eliminado)
                    System.out.println("Estudiante eliminado: "+estudiante);
                else
                    System.out.println("Estudiante no eliminado: "+estudiante);
                break;
            case 6: //Salir
                System.out.println("Programa finalizado. Hasta pronto!!!");
                salir = true;
                break;
            default:
                System.out.println("Opción incorrecta, digite un valor del 1 al 6: ");                
        }// Fin switch
        return salir;
    }
}//Fin Clase