package com.tienda.mintic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.mintic.dao.ProveedorDao;
import com.tienda.mintic.model.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorDao proveedordao;

	@Override
	public Iterable<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return proveedordao.findAll();
	}

	@Override
	public Optional<Proveedor> findById(Long nit) {
		// TODO Auto-generated method stub
		return proveedordao.findById(nit);
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedordao.save(proveedor);
	}

	@Override
	public void delete(Long nit) {
		// TODO Auto-generated method stub
		proveedordao.deleteById(nit);
	}
	

	
	

}
