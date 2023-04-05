/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.protectora.protectora.controller;

import com.protectora.protectora.model.Busqueda;
import com.protectora.protectora.service.BusquedaService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/busqueda")
public class BusquedaController {
    @Autowired
    BusquedaService busquedaService;
    
    @GetMapping
    @ResponseBody
    public List<Busqueda>verBusquedas(){
        return busquedaService.verBusquedas();
    }
            
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Busqueda> agregarBusqueda(@ModelAttribute Busqueda busq){
        busquedaService.agregar(busq);
        return new ResponseEntity<>(busq, HttpStatus.CREATED);
    }
  
    
   @DeleteMapping("/{id}")
    public void eliminarBusqueda(@PathVariable Long id){
    busquedaService.eliminar(id);
    }
    
    
     @PutMapping
    public void modificarBusqueda(@RequestBody Busqueda busq){
    busquedaService.editar(busq);
    }
}
