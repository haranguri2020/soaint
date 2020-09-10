package com.carrito.servicios.model.tabla;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DETALLEVENTA")

public class DetalleVenta implements Serializable {
	
private static final long serialVersionUID=1L;
@Id
@Column(name="IDDETALLEVENTA")
private Integer idDetalleVenta; 

@Column(name="IDVENTA")
private Integer idVenta; 

@Column(name="IDPRODUCTO")
private Integer idproducto;

public Integer getIdDetalleVenta() {
	return idDetalleVenta;
}

public void setIdDetalleVenta(Integer idDetalleVenta) {
	this.idDetalleVenta = idDetalleVenta;
}

public Integer getIdVenta() {
	return idVenta;
}

public void setIdVenta(Integer idVenta) {
	this.idVenta = idVenta;
}

public Integer getIdproducto() {
	return idproducto;
}

public void setIdproducto(Integer idproducto) {
	this.idproducto = idproducto;
} 


}
