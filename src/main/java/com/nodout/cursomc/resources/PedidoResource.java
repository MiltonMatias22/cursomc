package com.nodout.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nodout.cursomc.domain.Pedido;
import com.nodout.cursomc.services.PedidoService;

/**
 * @author: Milton Matias
 * @crida: 17-02-2018
 * @modificada: 17-02-2018
 * @version: V1.0
 */

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido pedido = service.buscar(id);
		
		return ResponseEntity.ok().body(pedido);		
	}

}
