package com.carrito.servicios.db;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.carrito.servicios.util.Globales; 

public class ConnectionDB {

	public static Connection getConnectionServer() {
		// OBTIENE LA CONEXION DEL SERVIDOR DE APLICACIONES
		Connection conn = null;
		try {
			InitialContext c = new InitialContext();
			DataSource jdbcFactory = (DataSource) c.lookup(Globales.JNDI);
			conn = jdbcFactory.getConnection();
		} catch (NamingException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
