package com.carrito.servicios.negocio;

 
import com.carrito.servicios.model.socio.ConsultaClienteResponse;
 
public interface SocioInterface {

	public ConsultaClienteResponse listarCliente(String identificador,String documento) ;

}
