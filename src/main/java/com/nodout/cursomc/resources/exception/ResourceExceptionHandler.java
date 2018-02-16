package com.nodout.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nodout.cursomc.services.exceptions.ObjectNotFoundException;



/**
 * @author: Milton Matias
 * Create: 16-02-2018
 * UpDate: 16-02-2018
 * Function: Interceptar e Manipular as exceções do recurso.
 */

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/**
	 * @param  e = exceção
	 * @param  request = informações da quequisição.
	 * @return  StandardError = erro padrão
	 * 
	 * @ExceptionHandle: para indicar que o método é um tratador de
	 * tipo de exceção ObjectNotFoundException a qual criamos.
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
			HttpServletRequest request){
		
		/**@param status, @param mensagem e @Param tempo */
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), System.currentTimeMillis());
		//Aqui pode ser enviado uma página de erro?
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
