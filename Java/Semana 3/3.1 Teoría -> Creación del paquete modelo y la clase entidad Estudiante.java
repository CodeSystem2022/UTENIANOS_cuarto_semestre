package utn.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data //boilerplate-Repetitivo
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiantes2022 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//llaves autoincrementables
    private Integer idestudiantes2022;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}


package utn.estudiantes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.estudiantes.modelo.Estudiantes2022;

public interface EstudianteRepositorio extends JpaRepository<Estudiantes2022,Integer> {
}


package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiantes2022;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiantes2022> listarEstudiantes();
    public Estudiantes2022 buscarEstudiantePorId(Integer idEstudiante2022);
    public void guardarEstudiante (Estudiantes2022 estudiantes2022);
    public void eliminarEstudiante( Estudiantes2022 estudiantes2022);
}


package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiantes2022> listarEstudiantes() {
        List<Estudiantes2022> estudiantes2022 = estudianteRepositorio.findAll();
        return estudiantes2022;//recuperamos todos los objetos del tipo estudiante
    }

    @Override
    public Estudiantes2022 buscarEstudiantePorId(Integer idEstudiante2022) {
        Estudiantes2022 estudiantes2022 = estudianteRepositorio.findById(idEstudiante2022).orElse(null);
        return estudiantes2022; // orElse devuelve null si no consigue devolver un valor encontrado
    }

    @Override
    public void guardarEstudiante(Estudiantes2022 estudiantes2022) {
        estudianteRepositorio.save(estudiantes2022);
    }

    @Override
    public void eliminarEstudiante(Estudiantes2022 estudiantes2022) {
        estudianteRepositorio.delete(estudiantes2022);
    }
}

