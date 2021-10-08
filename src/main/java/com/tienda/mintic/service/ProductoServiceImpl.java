package com.tienda.mintic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.mintic.dao.ProductoDao;
import com.tienda.mintic.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productodao;
	
	@Override
	public Iterable<Producto> findAll() {
		// TODO Auto-generated method stub
		return productodao.findAll();
	}

	@Override
	public Optional<Producto> findById(Long codigo) {
		// TODO Auto-generated method stub
		return productodao.findById(codigo);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productodao.save(producto);
	}

	@Override
	public void delete(Long codigo) {
		// TODO Auto-generated method stub
		productodao.deleteById(codigo);
	}

}
