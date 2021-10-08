package com.tienda.mintic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	
	@Id
	private Long codigo;

	private String nombre;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	private Proveedor nit;

	private String precio_compra;

	private String ivacompra;
	
	private String precio_venta;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proveedor getNit() {
		return nit;
	}

	public void setNit(Proveedor nit) {
		this.nit = nit;
	}

	public String getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(String precio_compra) {
		this.precio_compra = precio_compra;
	}

	public String getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(String ivacompra) {
		this.ivacompra = ivacompra;
	}

	public String getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(String precio_venta) {
		this.precio_venta = precio_venta;
	}

	
	
	
}
