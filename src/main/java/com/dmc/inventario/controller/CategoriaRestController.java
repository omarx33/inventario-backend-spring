package com.dmc.inventario.controller;

import com.dmc.inventario.response.CategoriaResponseRest;
import com.dmc.inventario.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
