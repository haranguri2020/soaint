package com.carrito.servicios.model.socio;

import java.util.List;

 
import pe.carrito.servicios.model.solicitudes.SolicitudResponse;

public class ConsultaClienteResponse extends SolicitudResponse {

	private List<ClienteResponse> lista;

	public List<ClienteResponse> getLista() {
		return lista;
	}

	public void setLista(List<ClienteResponse> lista) {
		this.lista = lista;
	}

}
