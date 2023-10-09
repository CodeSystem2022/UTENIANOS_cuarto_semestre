
package UTN.datos;

import static UTN.conexion.Conexion.getConnection;
import UTN.dominio.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    
    //METODO LISTAR
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        
        //Creamos algunos objetos que son necesarios para comunicarnos con la base de datos
        PreparedStatement ps; //ENVIA LA SENTENCIA SQL QUE VAMOS A EJECUTAR HACIA LA BASE DE DATOS
        ResultSet rs; //NOS PERMITE ALMACENAR EL RESULTADO QUE OBTENEMOS DESDE LA BASE DE DATOS
        
        //CREAMOS UN OBJETO DE TIPO CONEXION
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){//Mientras que existan registros que iterar va a seguir trabajando con el while
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                
                //AHORA VAMOS A AGREGARLO A LA LISTA
                estudiantes.add(estudiante);
            }
        }catch (Exception e){
            System.out.println("Ocurrió un error al seleccionar datos: "+e.getMessage());
        }finally{
            try{
            con.close();
            }catch (Exception e){
                System.out.println("Ocurrió un error al cerrar la conexión: "+e.getMessage());
            }
        }
        
        return estudiantes;
    }
    
    //METODO BUSCAR POR ID
    public boolean buscarEstudiantesPorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;//Si encuentra un registro retorna un bolleano true
            }//Fin if
        }catch (Exception e){
            System.out.println("Ocurrió un error al buscar estudiante: "+e.getMessage());
        }finally{
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrió un error al cerrar la conexión: "+e.getMessage());
            }
        }
        return false;
    }
    
    //METODO AGREGAR ESTUDIANTE
    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre()); //El nro representa el parámetro
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Ocurrió un error al agregar al estudiante: "+e.getMessage());
        }finally{
            try{
                con.close();
                
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión: "+e.getMessage());
            }
        }
        return false;
    }
    
    //METODO PARA MODIFICAR UN ESTUDAINTE
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre()); //El nro representa el parámetro
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            
            return true;
            
        }catch (Exception e){
            System.out.println("Ocurrió un error al modificar al estudiante: "+e.getMessage());
        }finally{
            try{
                con.close();
                
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión: "+e.getMessage());
            }
        }
        return false;
    }
    
    //METODO PARA ELIMINAR UN ESTUDIANTE
    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2022 WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Ocurrió un error al eliminar al estudiante: "+e.getMessage());
        }finally{
            try{
                con.close();
                
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión: "+e.getMessage());
            }
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        
        var estudianteDao = new EstudianteDAO();
        
//        //Modificar estudiante
//        var estudianteModificado = new Estudiante(1, "José", "Peral", "5544663321", "josep@mail.com");
//        var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
//        
//        if(modificado)
//           System.out.println("Estudiante modificado: "+estudianteModificado);
//        else
//            System.out.println("No se modificó el estudiante: "+estudianteModificado);
    
        
        
//        //Agregar estudiante
//        var nuevoEstudiante = new Estudiante("Carlos", "Lara", "5495544223", "carlosl@mail.com");
//        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
//        if(agregado)
//            System.out.println("Estudiante agregado: "+nuevoEstudiante);
//        else
//            System.out.println("No se agregó estudiante: "+nuevoEstudiante);

        //Eliminar estudiante con id=3
        var estudianteEliminar = new Estudiante(4);
        var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if(eliminado)
            System.out.println("Estudiante eliminado: "+estudianteEliminar);
        else
            System.out.println("No se eliminó estudiante: "+estudianteEliminar);



        //Listar los estudiantes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);//Función lambda para imprimir
        
//        //BUSCAR POR ID
//        var estudiante1 = new Estudiante(1); //Vamos a utilizar el constructor que trabaja solo con id
//        System.out.println("Estudiantes antes de la búsqueda: "+estudiante1);
//        var encontrado = estudianteDao.buscarEstudiantesPorId(estudiante1);
//        if(encontrado)
//            System.out.println("Estudiante encontrado: "+estudiante1);
//        else
//            System.out.println("No se encontró el estudiante: "+estudiante1.getIdEstudiante());
    }
        
    
}
