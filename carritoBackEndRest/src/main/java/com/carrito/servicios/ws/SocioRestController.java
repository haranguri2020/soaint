package com.carrito.servicios.ws;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.servicios.exception.DBException;
import com.carrito.servicios.model.socio.ConsultaClienteResponse;
import com.carrito.servicios.model.socio.ConsultarSocioResponse;
import com.carrito.servicios.negocio.SocioInterface;
import com.carrito.servicios.util.Constantes;
import com.carrito.servicios.util.UtilDate;
import com.carrito.servicios.util.UtilObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/banco")
public class SocioRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SocioInterface socioInterface;

	@GetMapping(value = "/{id}/consultar", produces = "application/json")
	public ResponseEntity<String> listarCliente(@PathVariable("id") String id) throws JsonProcessingException {
		long fechaInicio = UtilDate.getCurrentDateTime();
		ConsultaClienteResponse response=new ConsultaClienteResponse();
		String mensajeTransaccion=Constantes.VACIO;
		try {
			String identificador = UUID.randomUUID().toString();
			String nomMetodo=Constantes.NombreMetodo;
			mensajeTransaccion="[" + nomMetodo + " idTx=" + identificador + "] ";
			logger.info(mensajeTransaccion + "Datos de entrada: identificador:" + id);
			response = socioInterface.listarCliente(identificador, id);			

	 
		}
		finally {
			long fechafinal = UtilDate.getCurrentDateTime();
			logger.info("Tiempo de ejecucion:" + (fechafinal - fechaInicio));
		}
		
		return new ResponseEntity<String>(UtilObjectMapper.getObjectMapper().writeValueAsString(response),
				response.getHttpStatus());
	}
	
	
	 
}
