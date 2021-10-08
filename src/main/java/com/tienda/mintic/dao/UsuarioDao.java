package com.tienda.mintic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.mintic.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	
	
}
