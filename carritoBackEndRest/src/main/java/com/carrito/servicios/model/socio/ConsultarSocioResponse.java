package com.carrito.servicios.model.socio;

import java.util.List;

import pe.carrito.servicios.model.solicitudes.SolicitudResponse;

public class ConsultarSocioResponse extends SolicitudResponse {

	private List<SocioResponse> lista;

	public List<SocioResponse> getLista() {
		return lista;
	}

	public void setLista(List<SocioResponse> lista) {
		this.lista = lista;
	}

}
