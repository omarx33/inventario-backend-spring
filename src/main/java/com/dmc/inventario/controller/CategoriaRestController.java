package com.dmc.inventario.controller;

import com.dmc.inventario.models.Categoria;
import com.dmc.inventario.response.CategoriaResponseRest;
import com.dmc.inventario.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {
    @Autowired
    private ICategoriaService servicio;
    @GetMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> buscarCategorias(){
        ResponseEntity<CategoriaResponseRest> respuesta = servicio.search();
        return respuesta;
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> buscarCategoriasPorId(@PathVariable Long id){
        ResponseEntity<CategoriaResponseRest> respuesta = servicio.searchById(id);
        return respuesta;
    }


    @PostMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> registrar(@RequestBody Categoria categoria){
        ResponseEntity<CategoriaResponseRest> respuesta = servicio.save(categoria);
        return respuesta;
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriaResponseRest> update(@RequestBody Categoria categoria, @PathVariable Long id){
        ResponseEntity<CategoriaResponseRest> respuesta = servicio.update(categoria,id);
        return respuesta;
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<CategoriaResponseRest> update(@PathVariable Long id){
        ResponseEntity<CategoriaResponseRest> respuesta = servicio.deleteById(id);
        return respuesta;
    }
}
