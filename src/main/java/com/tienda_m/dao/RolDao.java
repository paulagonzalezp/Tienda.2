package com.tienda_m.dao;

import com.tienda_m.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao
        extends JpaRepository<Rol, Long> {

}
