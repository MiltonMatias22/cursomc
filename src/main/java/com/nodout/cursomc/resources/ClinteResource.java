package com.nodout.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nodout.cursomc.domain.Cliente;
import com.nodout.cursomc.services.ClienteService;

/**
 * @author: Milton Matias
 * @crida: 15-02-2018
 * @modificada: 15-02-2018
 * @version: V1.0
 */

@RestController
@RequestMapping(value = "/clientes")
public class ClinteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente cliente = clienteService.buscar(id);
		
		return ResponseEntity.ok().body(cliente);		
	}

}
