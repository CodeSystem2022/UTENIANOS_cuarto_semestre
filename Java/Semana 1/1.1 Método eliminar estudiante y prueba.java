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
