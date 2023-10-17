package Utn.tienda_libros.vista;

import Utn.tienda_libros.modelo.Libro;
import Utn.tienda_libros.servicio.LibroServicio;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class LibroFrom extends JFrame {

    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField libroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroFrom(LibroServicio libroServicio){
        this.libroServicio= libroServicio;
        iniciarForma();
        agregarButton.addActionListener(e -> agregarLibro());


    }

    private void iniciarForma(){
         setContentPane(panel);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar la conexion
         setVisible(true);
         setSize(900,700);
        //para obtener las dimensiones de la ventana
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla= toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/2);
        int y= (tamanioPantalla.height - getHeight()/2);
        setLocation(x,y);
    }

    private void agregarLibro(){
        //leer los valores del formulario
        if(libroTexto.getText().equals("")){
            mostrarMensaje("Ingrese el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        //tomamos los campos llenados por el usuairio en las cajas de texto
        var nombreLibro= libroTexto.getText();
        var autor = autorTexto.getText();
        var precio= Double.parseDouble(precioTexto.getText());
        var existencias= Integer.parseInt(existenciasTexto.getText());
        //creamos el objeto libro
        var libro= new Libro(null,nombreLibro,autor,precio,existencias);
         //libro.setNombreLibro(nombreLibro);
        // libro.setAutor(autor);
        // libro.setPrecio(precio);
        // libro.setExistencias(existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agregó el libro correctamente");
        limpiarFormulario();
        listarLibros();


    }

    private void limpiarFormulario(){
        libroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        existenciasTexto.setText("");
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);
    }


    private void createUIComponents() {
        //tabla modelo libros
        this.tablaModeloLibros= new DefaultTableModel(0,5);//5 columnas
        String[] cabecera={"Id", "Libro", "Autor","Precio"," Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabecera);

        // Instanciar el objeto de JTable
        this.tablaLibros=  new JTable(tablaModeloLibros);
        listarLibros();

    }

    private void listarLibros(){
        //Limpiar la Tabla
        tablaModeloLibros.setRowCount(0);//CON ESTO SE LIMPIA LA TABLA
        //obtenemos los libros de BD
        var libros= libroServicio.listarLibros();
        //iteramos cada libro
        libros.forEach((libro) -> {//funcion lambda para iterar
            //creamos cada registro para agregarlos a la tabla
            Object [] renglonLibro={ // cremaos un registro
                    libro.getIdlibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
           this.tablaModeloLibros.addRow(renglonLibro);//agregamos al registro al modelo
        });
    }
}
