package com.carrito.servicios.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	private String codError;
	private String ubiError;

	
	/**
	 * Constructores
	 */
	public BaseException(String codError, String message, Exception exception) {
		super(message, exception);
		this.codError = codError;
	}
	
	/**
	 * Constructores
	 */
	public BaseException(String codError, String message, String ubiError) {
		super(message);
		this.codError = codError;
	}

	/**
	 * Constructores
	 */
	public BaseException(String codError, String message, Throwable exception) {
		super(message, exception);
		this.codError = codError;
	}
	
	public BaseException(String codError, String message) {
		super(message);
		this.codError = codError;
	}

	/**
	 * Constructores
	 */
	public BaseException(String message, Exception exception) {
		super(message, exception);
	}

	/**
	 * Constructores
	 */
	public BaseException(String message, Throwable exception) {
		super(message, exception);
	}

	/**
	 * Constructores
	 */
	public BaseException(Exception exception) {
		super(exception);
	}

	/**
	 * Constructores
	 */
	public BaseException(String message) {
		super(message);
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getUbiError() {
		return ubiError;
	}

	public void setUbiError(String ubiError) {
		this.ubiError = ubiError;
	}

}
