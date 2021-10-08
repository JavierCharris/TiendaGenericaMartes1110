package com.tienda.mintic.service;

import java.util.Optional;

import com.tienda.mintic.model.Proveedor;

public interface ProveedorService {

	public Iterable<Proveedor> findAll();
	
	public Optional<Proveedor> findById(Long nit);
	
	public Proveedor save(Proveedor proveedor);
	
	public void delete(Long nit);

	
}
