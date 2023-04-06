/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.protectora.protectora.service;

import com.protectora.protectora.model.Busqueda;
import com.protectora.protectora.repository.IbusquedaRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BusquedaService implements IbusquedaService {

    @Autowired
    IbusquedaRepository ibusqRepository;


 /*@Override
 public void agregar(Busqueda busqueda) {
     MultipartFile imagen = busqueda.getImg();
     if (imagen != null) {
         try {

            String nombreImagen = imagen.getOriginalFilename();
          String rutaImagen = "src/main/resources/imagenes/" + nombreImagen;
             byte[] bytes = imagen.getBytes();
             Path ruta = Paths.get(rutaImagen);
             Files.write(ruta, bytes);
             busqueda.setRutaImagen(nombreImagen);
         } catch (IOException ex) {
             Logger.getLogger(BusquedaService.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Error al guardar la imagen: " + ex.getMessage(), ex);
         }
     }
     ibusqRepository.save(busqueda);
 }*/


  public void agregar(Busqueda busqueda) {
    MultipartFile imagen = busqueda.getImg();
    if (imagen != null) {
        try {
            String nombreImagen = imagen.getOriginalFilename();
           // String rutaImagen = "src/main/resources/imagenes/" + nombreImagen;
            String rutaImagen = new File("src/main/resources/imagenes/", nombreImagen).getAbsolutePath();

            byte[] bytes = imagen.getBytes();
            Path ruta = Paths.get(rutaImagen);
            Files.write(ruta, bytes);
            busqueda.setRutaImagen(nombreImagen);
        } catch (IOException ex) {
            Logger.getLogger(BusquedaService.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error al guardar la imagen: " + ex.getMessage(), ex);
        }
    }
    ibusqRepository.save(busqueda);
}
    @Override
    public void eliminar(Long id) {
        ibusqRepository.deleteById(id);
    }

    @Override
    public void editar(Busqueda busq) {
        ibusqRepository.save(busq);
    }

    @Override
    public List<Busqueda> verBusquedas() {
        return ibusqRepository.findAll();
    }

}
