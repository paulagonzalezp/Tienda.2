package com.tienda_m.dao;

import com.tienda_m.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutoDao extends JpaRepository<Producto,Long>{
    
}
