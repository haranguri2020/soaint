package com.carrito.servicios.model.tabla;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTO")

public class Producto implements Serializable {

	private static final long serialVersionUID=1L;

	@Id
	@Column(name="IDPRODUCTO")
	private Integer idProducto; 

	@Column(name="NOMBRE")
	private String nombre; 
	
	@Column(name="PRECIO")
	private String precio;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	} 
	
	
}
