package com.carrito.servicios.repositorio;

import java.util.List;

import com.carrito.servicios.exception.DBException;
import com.carrito.servicios.model.tabla.ResponseListarTablaResultSet;

public interface TablaDaoInterface {

	public List<ResponseListarTablaResultSet> listarTabla(String identificador, String documento) throws DBException ;
}
