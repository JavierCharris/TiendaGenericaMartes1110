package com.tienda.mintic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.mintic.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long>{

}
