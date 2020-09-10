package com.carrito.servicios.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class Globales {

	/*
	 * PARAMETROS GLOBALES CONFIGURABLES
	 */
	public static String ESQUEMA_PROC;
	public static String JNDI;	
	public static String CodigoExito;
	public static String CodigoError;
	public static String CodigoNoData;
	public static String MensajeExito;
	public static String MensajeError;
	public static String MensajeNoData;
	public static int CACHE_USUARIO_HORA_FENCIMIENTO;
	public static int CACHE_USUARIO_MINUTO_FENCIMIENTO;
	public static String FLAG;
	/*
	 * PARAMETROS GLOBALES FIJOS
	 */	
	
	public static String SP_CONSULTARDATOSCLIENTE_OTP;
	
	// SETTER
	public void setJNDI_AS400(String jNDI) {
		this.JNDI = jNDI;
	}
	public void setSP_CONSULTARDATOSCLIENTE_OTP(String sP_CONSULTARDATOSCLIENTE_OTP) {
		this.SP_CONSULTARDATOSCLIENTE_OTP = sP_CONSULTARDATOSCLIENTE_OTP;
	}
	public void setESQUEMA_PROC(String eSQUEMA_PROC) {
		this.ESQUEMA_PROC = eSQUEMA_PROC;
	}	
	public void setCodigoExito(String codigoExito) {
		this.CodigoExito = codigoExito;
	}
	public void setCodigoError(String codigoError) {
		this.CodigoError = codigoError;
	}	
	public void setMensajeExito(String mensajeExito) {
		this.MensajeExito = mensajeExito;
	}
	public void setMensajeError(String mensajeError) {
		this.MensajeError = mensajeError;
	} 
	public  void setCACHE_USUARIO_HORA_FENCIMIENTO(int cACHE_USUARIO_HORA_FENCIMIENTO) {
		this.CACHE_USUARIO_HORA_FENCIMIENTO = cACHE_USUARIO_HORA_FENCIMIENTO;
	} 
	public  void setCACHE_USUARIO_MINUTO_FENCIMIENTO(int cACHE_USUARIO_MINUTO_FENCIMIENTO) {
		this.CACHE_USUARIO_MINUTO_FENCIMIENTO = cACHE_USUARIO_MINUTO_FENCIMIENTO;
	}
	public void setFLAG(String fLAG) {
		this.FLAG = fLAG;
	}
	
	public  void setCodigoNoData(String codigoNoData) {
		this.CodigoNoData = codigoNoData;
	}

	public  void setMensajeNoData(String mensajeNoData) {
		this.MensajeNoData = mensajeNoData;
	}
	
	
	
}
