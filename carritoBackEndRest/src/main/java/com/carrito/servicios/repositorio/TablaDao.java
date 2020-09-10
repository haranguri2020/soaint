package com.carrito.servicios.repositorio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.carrito.servicios.db.ConnectionDB;
import com.carrito.servicios.exception.DBException;
import com.carrito.servicios.model.tabla.ResponseListarTablaResultSet;
import com.carrito.servicios.util.Globales;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class TablaDao implements TablaDaoInterface {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<ResponseListarTablaResultSet> listarTabla(String identificador, String documento) throws DBException{
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String listaRes = null;
		List<ResponseListarTablaResultSet> lista = new ArrayList<>();
		;
		StringBuilder sbSQL = new StringBuilder();
		try {
			sbSQL.append("{CALL ").append(Globales.ESQUEMA_PROC);
			sbSQL.append(".").append(Globales.SP_CONSULTARDATOSCLIENTE_OTP).append("(?,?)}");

			conn = ConnectionDB.getConnectionServer();
			cs = conn.prepareCall(sbSQL.toString());
			cs.setString(1, documento);
			cs.setString(2, Globales.FLAG);
			cs.execute();
			rs = cs.getResultSet();

			ResponseListarTablaResultSet responseTablaTablaResultSet = null;
			while (rs.next()) {
				responseTablaTablaResultSet = new ResponseListarTablaResultSet();
				responseTablaTablaResultSet.setCodRel(rs.getString(1));
				responseTablaTablaResultSet.setPriNomt(rs.getString(2));
				responseTablaTablaResultSet.setSegNomt(rs.getString(3));
				responseTablaTablaResultSet.setApePat(rs.getString(4));
				responseTablaTablaResultSet.setApeMat(rs.getString(5));
				responseTablaTablaResultSet.setTlfCelc(rs.getString(6));
				responseTablaTablaResultSet.setEmail(rs.getString(7));

				lista.add(responseTablaTablaResultSet);
			}
			
			listaRes=new ObjectMapper().writeValueAsString( lista );
			logger.info("Consulta de datos del socio exitosa: "+listaRes);

		} catch (Exception ex) {
			 
			ex.printStackTrace();
			logger.info("Exception Error en la base de datos: "+ex.getMessage());			
			throw new DBException(Globales.CodigoError, Globales.JNDI, Globales.SP_CONSULTARDATOSCLIENTE_OTP, Globales.MensajeError, ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cs != null)
					cs.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
		return lista;
	}

}
