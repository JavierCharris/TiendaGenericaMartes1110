package com.tienda.mintic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.mintic.dao.ClienteDao;
import com.tienda.mintic.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao clientedao;
	
	@Override
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clientedao.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long cedula) {
		// TODO Auto-generated method stub
		return clientedao.findById(cedula);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clientedao.save(cliente);
	}

	@Override
	public void delete(Long cedula) {
		clientedao.deleteById(cedula);
		
	}

	
	
}
