package com.tienda_m.service;

import com.tienda_m.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


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
    
    // Esta consulta utiliza consultas ampliadas
    public List<Producto> metodoJPA(double precioInf, double precioSup);

    // Esta consulta utiliza consultas JPQL
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    // Esta consulta utiliza consultas SQL
    public List<Producto>metodoSQL(double precioInf, double precioSup);
}

