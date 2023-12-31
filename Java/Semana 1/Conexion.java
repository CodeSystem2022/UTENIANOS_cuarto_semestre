package UTN.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConnection(){

        Connection conexion = null;

        //Variables para conectarnos a la base de datos
        var baseDatos = "Estudiantes";
        var url = "jdbc:mysql://localhost:3306/"+baseDatos;
        var usuario = "root";
        var password = "root";

        //Cargamos la clase del driver de mysql en memoria
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, usuario, password);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Ocurrió el siguiente error en la conexión: "+e.getMessage());
        }//Fin catch
        return conexion;
    }//Fin método Connection


    }

