package com.tienda_m.service;

import com.tienda_m.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //SE DEFINE LA FIRMA DEL METODO PARA OBTENER LOS REGISTROS DE CATEGORIA, EN FORMA DE LISTA
    public List<Categoria> getCategorias(boolean activo);
}
