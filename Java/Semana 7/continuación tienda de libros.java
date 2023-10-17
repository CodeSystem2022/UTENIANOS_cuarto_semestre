package Utn.tienda_libros.repositorio;

import Utn.tienda_libros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository <Libro, Integer>{
}


package Utn.tienda_libros.servicio;

import Utn.tienda_libros.modelo.Libro;

import java.util.List;

public interface ILibroServicio {

    public List<Libro> listarLibros();
    public Libro buscarLibroPorId(Integer idLibro);
    public void guardarLibro(Libro Libro);
    public void eliminarLibro(Libro libro);

}


package Utn.tienda_libros.servicio;


import Utn.tienda_libros.modelo.Libro;
import Utn.tienda_libros.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio implements ILibroServicio {
    @Autowired//agrega de forma automatica una instancia
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro buscarLibroPorId(Integer idLibro) {
        Libro libro= libroRepositorio.findById(idLibro).orElse(null);
        return libro;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
     libroRepositorio.delete(libro);//se pasa todo el objeto para eliminar
    }
}

public class LibroFrom extends JFrame {

    LibroServicio libroServicio;
    private JPanel panel;

    @Autowired
    public LibroFrom(LibroServicio libroServicio){
        this.libroServicio= libroServicio;
        iniciarForma();
    }

    private void iniciarForma(){
         setContentPane(panel);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar la conexion
         setVisible(true);
         setSize(900,700);
    }


}
