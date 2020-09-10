package com.carrito.servicios.model.tabla;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {
	
private static final long serialVersionUID=1L;
@Id
@Column(name="IDCLIENTE")
private Integer idCliente; 

@Column(name="NOMBRE")
private String nombre;

@Column(name="APELLIDO")
private String apellido;

@Column(name="DNI")
private String dni;

@Column(name="TELEFONO")
private String telefono;

@Column(name="EMAIL")
private String email;

public Integer getIdCliente() {
	return idCliente;
}
public void setIdCliente(Integer idCliente) {
	this.idCliente = idCliente;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Cliente(Integer idCliente, String nombre, String apellido, String dni, String telefono, String email) {
	super();
	this.idCliente = idCliente;
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	this.telefono = telefono;
	this.email = email;
}
public Cliente() {
	super();
	// TODO Auto-generated constructor stub
}
 





}
