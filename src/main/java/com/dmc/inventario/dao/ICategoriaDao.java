package com.dmc.inventario.dao;

import com.dmc.inventario.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {
}
