package com.tienda.mintic.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.mintic.model.Proveedor;

import com.tienda.mintic.service.ProveedorService;


@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorservice;
	
	//*Crear un nuevo usuario
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Proveedor proveedor) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorservice.save(proveedor));
		
	}
	
	// Leer un Usuario
	@GetMapping("{nit}")
	public ResponseEntity<?> read (@PathVariable(value = "nit") Long nitproveedor){
		
		Optional<Proveedor> oProveedor = proveedorservice.findById(nitproveedor);
		if(!oProveedor.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oProveedor);
		
	}
	
	
	//Actualizar un Usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Proveedor proveedorDetails, @PathVariable(value = "id") Long nitproveedor){
		
		Optional<Proveedor> uProveedor = proveedorservice.findById(nitproveedor);
		

		if(!uProveedor.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(usuarioDetails, uUsuario.get());
		
		uProveedor.get().setNombre(proveedorDetails.getNombre());
		uProveedor.get().setDireccion(proveedorDetails.getDireccion());
		uProveedor.get().setTelefono(proveedorDetails.getTelefono());
		uProveedor.get().setCiudad(proveedorDetails.getCiudad());
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorservice.save(uProveedor.get()));
		
	}
	
	
	
	@DeleteMapping("/{nit}")
	public ResponseEntity<?> delete (@PathVariable(value = "nit") Long nitproveedor){
		
		if(!proveedorservice.findById(nitproveedor).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		proveedorservice.delete(nitproveedor);
		return ResponseEntity.ok().build();
	
	}
	
	
	
	@GetMapping
	public List<Proveedor> readAll () {
		
		List<Proveedor> proveedor = StreamSupport
				.stream(proveedorservice.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return proveedor;
	}
	
}
