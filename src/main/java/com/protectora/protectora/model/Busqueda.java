
package com.protectora.protectora.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Entity
public class Busqueda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    
    @Basic
    String nombre;
    String localidad;
    String telefono;
    @Transient
    MultipartFile img;
    String rutaImagen;
    
    
    //CONSTRUCTORES

    public Busqueda() {
    }

    public Busqueda(String nombre, String localidad, String telefono, MultipartFile img, String rutaImagen) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.telefono = telefono;
        this.img = img;
        this.rutaImagen = rutaImagen;
    }

  

   
    
}
