package com.dmc.inventario.services;


import com.dmc.inventario.models.Categoria;
import com.dmc.inventario.response.CategoriaResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoriaService {
    public ResponseEntity<CategoriaResponseRest> search();
    public ResponseEntity<CategoriaResponseRest> searchById(Long id);
    public ResponseEntity<CategoriaResponseRest> save(Categoria id);
    public ResponseEntity<CategoriaResponseRest> update(Categoria categoria,Long id);
    public ResponseEntity<CategoriaResponseRest> deleteById(Long id);
}
