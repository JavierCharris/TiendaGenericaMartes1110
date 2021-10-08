package com.tienda.mintic.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.mintic.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

}

