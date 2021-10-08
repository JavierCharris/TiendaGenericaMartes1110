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

import com.tienda.mintic.model.Producto;
import com.tienda.mintic.service.ProductoService;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoservice;
	
	//*Crear un nuevo usuario
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Producto producto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoservice.save(producto));
		
	}
	
	// Leer un Usuario
	@GetMapping("{codigo}")
	public ResponseEntity<?> read (@PathVariable(value = "codigo") Long codigoproducto){
		
		Optional<Producto> oProducto = productoservice.findById(codigoproducto);
		if(!oProducto.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oProducto);
		
	}
	
	
	//Actualizar un Usuario
	@PutMapping("/{codigo}")
	public ResponseEntity<?> update (@RequestBody Producto productoDetails, @PathVariable(value = "codigo") Long codigoproducto){
		
		Optional<Producto> uProducto = productoservice.findById(codigoproducto);
		

		if(!uProducto.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(usuarioDetails, uUsuario.get());
		
		uProducto.get().setNombre(productoDetails.getNombre());
		uProducto.get().setPrecio_compra(productoDetails.getPrecio_compra());
		uProducto.get().setPrecio_venta(productoDetails.getPrecio_venta());
		uProducto.get().setNit(productoDetails.getNit());
		uProducto.get().setIvacompra(productoDetails.getIvacompra());
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoservice.save(uProducto.get()));
		
	}
	
	
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete (@PathVariable(value = "codigo") Long codigoproducto){
		
		if(!productoservice.findById(codigoproducto).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoservice.delete(codigoproducto);
		return ResponseEntity.ok().build();
	
	}
	
	
	
	@GetMapping
	public List<Producto> readAll () {
		
		List<Producto> proveedor = StreamSupport
				.stream(productoservice.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return proveedor;
	}
	
	
}
