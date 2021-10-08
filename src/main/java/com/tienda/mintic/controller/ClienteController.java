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

import com.tienda.mintic.model.Cliente;
import com.tienda.mintic.service.ClienteService;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// *Crear un nuevo cliente

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));

	}

	// Leer un Cliente
	@GetMapping("/{cedula}")
	public ResponseEntity<?> read(@PathVariable(value = "cedula") Long clienteid) {

		Optional<Cliente> oUsuario = clienteService.findById(clienteid);

		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(oUsuario);

	}

	// Actualizar Cliente
	@PutMapping("/{cedula}")
	public ResponseEntity<?> update(@RequestBody Cliente clienteDetails, @PathVariable(value = "cedula") Long clienteid) {

		Optional<Cliente> uCliente = clienteService.findById(clienteid);

		if (!uCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		uCliente.get().setCedula_cliente(clienteDetails.getCedula_cliente());
		uCliente.get().setNombre_completo(clienteDetails.getNombre_completo());
		uCliente.get().setCorreo_electronico(clienteDetails.getCorreo_electronico());
		uCliente.get().setDireccion(clienteDetails.getDireccion());
		uCliente.get().setTelefono(clienteDetails.getTelefono());

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(uCliente.get()));

	}

	// Borrar un cliente
	@DeleteMapping("/{cedula}")
	public ResponseEntity<?> delete(@PathVariable(value = "cedula") Long clienteid) {

		if (!clienteService.findById(clienteid).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		clienteService.delete(clienteid);
		return ResponseEntity.ok().build();

	}

	// Obtener todos los usuarios
	@GetMapping
	public List<Cliente> readAll() {

		List<Cliente> cliente = StreamSupport.stream(clienteService.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return cliente;
	}

}