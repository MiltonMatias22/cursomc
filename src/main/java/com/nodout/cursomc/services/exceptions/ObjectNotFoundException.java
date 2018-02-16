package com.nodout.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	/**
	 * Número de versão
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String menssagem) {
		super(menssagem);
	}
	
	public ObjectNotFoundException(String menssagem, Throwable cause) {
		super(cause);
	}

}
