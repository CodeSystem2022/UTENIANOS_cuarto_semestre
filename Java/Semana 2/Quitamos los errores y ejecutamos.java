package utn.presentacion;

import utn.estudiante.datos.EstudianteDAO;
import utn.estudiante.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstdiantesApp {
    public static void main(String[] args) {

        var salir= false;
        var consola= new Scanner(System.in);
        //creamos una instancia de la clase servicio, lo haremos fuera del ciclo
        var estudianteDao= new EstudianteDAO();
        while (!salir){
            try{
                mostrarMenu();// este sera el metodo que ejecuta el menu que devolvera el booleano
                salir= ejecutarOpciones(consola,estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar la operación: "+ e.getMessage());
            }

        }//fin while
    }//fin main

  private static void mostrarMenu(){

      System.out.println("""
              ******SISTEMA DE ESTUDIANTES ******
                  
              1) LISTAR LOS ESTUDIANTES.
              2) BUSCAR UN ESTUDIANTE.
              3) AGREGAR UN ESTUDIANTE.
              4) MODIFICAR UN ESTUDIANTE.
              5) ELIMINAR UN ESTUDIANTE.
              6) SALIR DEL SISTEMA.
              Elija la opción deseada: 
              
              """);
  }
  //metodo para ejecutar las opciones, devuelve un booleano, se puede modificar la variable salir para terminar ciclo
  private static boolean ejecutarOpciones(Scanner consola,EstudianteDAO estudianteDao){
          var opcion= Integer.parseInt(consola.nextLine());
          var salir= false;
          switch (opcion){
              case 1 -> { // listar estudiantes

                  System.out.println("Listado de estudiantes:");// recupera informacion y muestra
                  var estudiantes= estudianteDao.listarEstudiantes();//recibe el listado
                  //iteramos cada objeto del tipo estudiante
                  estudiantes.forEach(System.out::println);// imprimos la lista
                  }//fin case 1
              case 2 ->{//buscar estudiante por id
                  System.out.println("Introduce el ID del estudiante: ");
                  var idEstdudiante= Integer.parseInt(consola.nextLine());
                  var estudiante= new Estudiante(idEstdudiante);
                  var encontrado= estudianteDao.buscarEstudiantePorId(estudiante);
                  if(encontrado){
                      System.out.println("Estudiante encontrado: " + estudiante);
                  }else {
                      System.out.println("Estudiante no encontrado: " + estudiante);
                  }

              }// fin case 2

              case 3 ->{// agregar estudiante
                  System.out.println("AGREGAR ESTUDIANTE:");
                  System.out.println("Ingrese el nombre:");
                  var nombre= consola.nextLine();
                  System.out.println("Ingresar Apellido:");
                  var apellido= consola.nextLine();
                  System.out.println("Ingresar Teléfono");
                  var telefono= consola.nextLine();
                  System.out.println("Ingresar Email:");
                  var mail= consola.nextLine();
                  //con todos los datos creamos el objeto estudiante sin id
                  var estudiante= new Estudiante(nombre,apellido,telefono,mail);
                  var agregado= estudianteDao.agregarEstudiante(estudiante);
                  if(agregado){
                      System.out.println("Estudiante agregado: " + estudiante);
                  }else {
                      System.out.println("Estudiante NO agregado: " + estudiante);
                  }

              }//fin case 3
              case 4->{//modificar estudiante
                  System.out.println("Modificaremos el estudiante: ");
                  //debemos saber el id del objeto a modificar
                  System.out.println("Digite el id del estudiante a modificar: ");
                  var idEstudiante= Integer.parseInt(consola.nextLine());
                  System.out.println("Ingresar Nombre: ");
                  var nombre = consola.nextLine();
                  System.out.println("Ingresar Apellido:");
                  var apellido= consola.nextLine();
                  System.out.println("Ingresar Teléfono:");
                  var telefono= consola.nextLine();
                  System.out.println("Ingresar Email:");
                  var mail= consola.nextLine();
                  //crear el objeto a modificar
                  var estudiante= new Estudiante(idEstudiante,nombre,apellido,telefono,mail);
                  var modificado= estudianteDao.modificarEstudiante(estudiante);
                  if (modificado){
                      System.out.println("Estudiante modificado: " + estudiante);
                  }else{
                      System.out.println("Estudiante no modificado: " + estudiante);
                  }

              }//fin case 4
              case 5->{//elimimar estudiante
                  System.out.println("Eliminar estudiante: ");
                  System.out.println("Ingrese el id del estudiante a eliminar:");
                  var idEstudiante= Integer.parseInt(consola.nextLine());
                  var estudiante= new Estudiante(idEstudiante);
                  var eliminado= estudianteDao.eliminarEstudiante(estudiante);
                  if(eliminado){
                      System.out.println("Estudiante eliminado: " + estudiante);
                  }else{
                      System.out.println("Estudiante no eliminado " + estudiante);
                  }


              }//fin caso 5
              case 6->{ // salir
                  System.out.println("Hasta pronto!!!!");
                  salir= true;
              }//fin case 6
              default -> System.out.println("Opción no reconocida, intente nuevamente.");

          }//fin switch
           return salir;
  }//fin metodo



}//fin class
