package com.dmc.inventario.services;

import com.dmc.inventario.dao.ICategoriaDao;
import com.dmc.inventario.models.Categoria;
import com.dmc.inventario.response.CategoriaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicesImpl implements ICategoriaService {
    @Autowired
    private ICategoriaDao categoriaDao;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> search() { //se une con el controlador de buscarCategorias pasando antes por ICategoriaService
        CategoriaResponseRest responseRest = new CategoriaResponseRest();
        try {
            List<Categoria> categorias = (List<Categoria>) categoriaDao.findAll();
            responseRest.getCategoriaResponse().setCategorias(categorias);
            responseRest.setMetadata("Respuesta ok","00","Respuesta Exitosa");
        } catch (Exception e){
            responseRest.setMetadata("Respuesta no ok","-1","Error de consulta");
            e.getStackTrace();
            return new ResponseEntity<CategoriaResponseRest>(responseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaResponseRest>(responseRest, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> searchById(Long id) {

        CategoriaResponseRest responseRest = new CategoriaResponseRest();
        List<Categoria> lista = new ArrayList<>();
        try {

            Optional<Categoria> categoria = categoriaDao.findById(id);
            if (categoria.isPresent()){

                lista.add(categoria.get());
                responseRest.getCategoriaResponse().setCategorias(lista);
                responseRest.setMetadata("Respuesta  ok","00","Categoria encontrada");

            }else {
                responseRest.setMetadata("Respuesta no ok","-1","Categoria no encontrada");
                return new ResponseEntity<CategoriaResponseRest>(responseRest, HttpStatus.NOT_FOUND);
            }


        } catch (Exception e){
            responseRest.setMetadata("Respuesta no ok","-1","Error de consulta por id");
            e.getStackTrace();
            return new ResponseEntity<CategoriaResponseRest>(responseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaResponseRest>(responseRest, HttpStatus.OK);
    }
}
