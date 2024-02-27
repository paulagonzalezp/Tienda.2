package com.tienda_m.service;

import com.tienda_m.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //SE DEFINE LA FIRMA DEL METODO PARA OBTENER LOS REGISTROS DE CATEGORIA, EN FORMA DE LISTA
    public List<Categoria> getCategorias(boolean activo);
    
    //Se recupera un registro tomando el idCategoria como clave de busqueda
    public Categoria getCategoria (Categoria categoria);
    
    //si idCategoria tiene un valor, se modifica ese registro,
    // si idcategoria No tiene valor se inserta  un nuevo registro
    public void save (Categoria categoria);
    
    //Se elimina el registro que tenga el valor del idCategoria pasado 
    public void delete (Categoria categoria);

    public Categoria getCategoriaPorId(Long idCategoria);
}
