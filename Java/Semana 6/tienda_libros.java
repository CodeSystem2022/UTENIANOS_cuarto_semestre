# CONEXION A MYSQL - ARCHIVO PROPERTIES

spring.datasource.url=jdbc:mysql://localhost:3306/tienda_libros_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password= // contraseña de cada uno
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver

#CREACION DE LA BASE DE DATOS EN CASO DE SER NECESARIO
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
  

package Utn.tienda_libros.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idlibro;
    String nombreLibro;
    String autor;
    Double precio;
    Integer existencias;

}
