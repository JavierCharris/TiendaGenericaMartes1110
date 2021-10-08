package com.tienda.mintic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuariodao;
	
	
	@Override
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuariodao.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long cedula) {
		// TODO Auto-generated method stub
		return usuariodao.findById(cedula);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuariodao.save(usuario);
	}

	@Override
	public void delete(Long cedula) {
		usuariodao.deleteById(cedula);
		
	}
	
	
	
	
}
