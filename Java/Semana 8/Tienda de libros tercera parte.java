package Utn.tienda_libros.vista;

import Utn.tienda_libros.servicio.LibroServicio;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class LibroFrom extends JFrame {

    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private DefaultTableModel tablaModeloLibros;

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
        //para obtener las dimensiones de la ventana
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla= toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/2);
        int y= (tamanioPantalla.height - getHeight()/2);
        setLocation(x,y);
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


package Utn.tienda_libros;

import Utn.tienda_libros.vista.LibroFrom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.EventQueue;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext contextoSpring =
				new SpringApplicationBuilder(TiendaLibrosApplication.class)
						.headless(false)
						.web(WebApplicationType.NONE)
						.run(args);

		//Ejecutamos el codigo para cargar el formulario
		EventQueue.invokeLater(() -> {//metodo lambda
			// obtenemos el objeto from a través del spring
			LibroFrom libroFrom = contextoSpring.getBean(LibroFrom.class);
			libroFrom.setVisible(true);
		});

	}//cierre main
}//Cierre class TiendaLibrosApplication
