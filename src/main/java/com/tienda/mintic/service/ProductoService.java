package com.tienda.mintic.service;

import java.util.Optional;

import com.tienda.mintic.model.Producto;

public interface ProductoService {

	public Iterable<Producto> findAll();
	
	public Optional<Producto> findById(Long codigo);
	
	public Producto save(Producto producto);
	
	public void delete(Long codigo);

	
}
