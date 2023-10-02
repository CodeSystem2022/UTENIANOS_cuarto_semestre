public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con= getConnection();
        String sql= "DELETE FROM  estudiantes2022 WHERE idestudiantes2022=?";
        try{
            ps= con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            ps.execute();
            return true;

        } catch (Exception e){
            System.out.println("Error al eliminar estudiante:" + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión: "+ e.getMessage());
            }
        }
        return false;
    } // fin método eliminar estudiante



// pruebas para eliminar estudiante

          var estudianteDao= new EstudianteDAO();

         // eliminar estudiante con id= 3
         var estudianteEliminar= new Estudiante(3);
         var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
         if (eliminado){
             System.out.println("Estudiante eliminado :" + estudianteEliminar);
         }else {
             System.out.println("No se pudo eliminar estudiante: "+ estudianteEliminar);
         }
