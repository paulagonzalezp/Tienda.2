package com.tienda_m.service;

import com.tienda_m.domain.Producto;
import java.util.List;


public interface ProductoService {
    //SE DEFINE LA FIRMA DEL METODO PARA OBTENER LOS REGISTROS DE CATEGORIA, EN FORMA DE LISTA
    public List<Producto> getProductos(boolean activo);
    
    //Se recupera un registro tomando el idProducto como clave de busqueda
    public Producto getProducto (Producto producto);
    
    //si idProducto tiene un valor, se modifica ese registro,
    // si idproducto No tiene valor se inserta  un nuevo registro
    public void save (Producto producto);
    
    //Se elimina el registro que tenga el valor del idProducto pasado 
    public void delete (Producto producto);

    public Producto getProductoPorId(Long idProducto);
}
