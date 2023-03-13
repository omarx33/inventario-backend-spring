package com.dmc.inventario.response;

import com.dmc.inventario.models.Categoria;
import lombok.Data;

import java.util.List;

@Data

public class CategoriaResponse {

    private List<Categoria> categorias;
}
