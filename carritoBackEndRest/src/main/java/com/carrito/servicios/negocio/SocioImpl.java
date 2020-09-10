package com.carrito.servicios.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.carrito.servicios.exception.DBException;
import com.carrito.servicios.model.socio.ClienteResponse;
import com.carrito.servicios.model.socio.ConsultaClienteResponse;
import com.carrito.servicios.model.socio.ConsultarSocioResponse;
import com.carrito.servicios.model.socio.SocioResponse;
import com.carrito.servicios.model.tabla.Cliente;
import com.carrito.servicios.model.tabla.ResponseListarTablaResultSet;
import com.carrito.servicios.repositorio.TablaDaoInterface;
import com.carrito.servicios.util.Constantes;
import com.carrito.servicios.util.Globales;

@Service
public class SocioImpl implements SocioInterface {
 	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
		

	@SuppressWarnings("unchecked")
	public ConsultaClienteResponse listarCliente (String identificador,String documento)   {
		ConsultaClienteResponse response = new ConsultaClienteResponse();
		List<ClienteResponse> listaRetorno = new ArrayList<ClienteResponse>();
		try {
			
	
		emf=Persistence.createEntityManagerFactory("Persistencia");
		manager=emf.createEntityManager();			
		manager.getTransaction().begin();
		List<Cliente> lc=(List<Cliente>)manager.createQuery("FROM CLIENTE").getResultList();
		//ultizamo funcion findStudent para encontra cliente en la lista.
		Optional<Cliente> rspcliente = findStudent(lc,Integer.valueOf((documento!=null?documento:"99999")));
		 if (!rspcliente.isPresent()) {
			 ClienteResponse c=new ClienteResponse();
			 c.setNombre(rspcliente.get().getNombre());
			 c.setApellido(rspcliente.get().getApellido());
			 c.setDni(rspcliente.get().getDni());
			 c.setTelefono(rspcliente.get().getTelefono());
			 c.setEmail(rspcliente.get().getEmail());
			 listaRetorno.add(c); 
		    }
		
		 response.setCodigoError(Globales.CodigoExito);
		 response.setLista(listaRetorno);
		}catch(Exception e) {
			response=null;
		}
		
		return response;
	}
	
	
	public Optional<Cliente> findStudent(List<Cliente> lc,Integer id) {
		//recorremos con stream lambda
	    return lc.stream()
	        .filter(s -> id.equals(s.getIdCliente()))
	        .findFirst();
	}
	
}
