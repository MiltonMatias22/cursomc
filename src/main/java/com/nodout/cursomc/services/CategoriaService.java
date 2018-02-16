package com.nodout.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodout.cursomc.domain.Categoria;
import com.nodout.cursomc.repositoreis.CategoriaRepository;
import com.nodout.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * @author: Milton Matias
 * Create: 15-02-2018
 * UpDate: 15-02-2018
 * Function: Oferecer as operações de consultas reacionadas a Categorias
 */

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	/**
	 * Function: Buscar um registro por id
	 * @param id
	 * @return categoria  
	 */
	public Categoria buscar(Integer id) {
		
		Categoria categoria =  repo.findOne(id);
		
		if(categoria == null) {
			// A camada de serviço recebe a exceção!
			throw new ObjectNotFoundException("Objeto não encontrado Id: "+ id
					+" Tipo: "+ Categoria.class.getName()); 
		}
		
		return 	categoria;
	}
	
}
