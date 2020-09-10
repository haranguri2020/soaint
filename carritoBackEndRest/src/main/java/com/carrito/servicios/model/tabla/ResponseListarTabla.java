package com.carrito.servicios.model.tabla;

import java.util.ArrayList;
import java.util.List;

public class ResponseListarTabla {

	private String codigoMensaje;
	private String mensaje;
	private List<ResponseListarTablaResultSet> lista = new ArrayList<ResponseListarTablaResultSet>();

	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<ResponseListarTablaResultSet> getLista() {
		return lista;
	}

	public void setLista(List<ResponseListarTablaResultSet> lista) {
		this.lista = lista;
	}

}
