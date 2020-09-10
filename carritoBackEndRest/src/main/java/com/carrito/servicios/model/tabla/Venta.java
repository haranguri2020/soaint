package com.carrito.servicios.model.tabla;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VENTA")
public class Venta implements Serializable {
	@Id
	@Column(name="IDVENTA")
	private Integer idVenta; 

	@Column(name="IDCLIENTE")
	private Integer idCLiente; 
	
	@Column(name="FECHA")
	private Date fecha;
}
