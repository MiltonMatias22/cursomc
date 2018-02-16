package com.nodout.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nodout.cursomc.domain.Categoria;
import com.nodout.cursomc.services.CategoriaService;

/**
 * @author: Milton Matias
 * @crida: 15-02-2018
 * @modificada: 15-02-2018
 * @version: V1.0
 */

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria categoria = service.buscar(id);
		
		return ResponseEntity.ok().body(categoria);		
	}

}
