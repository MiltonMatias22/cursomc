package com.nodout.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodout.cursomc.domain.Cliente;
import com.nodout.cursomc.repositoreis.ClienteRepository;
import com.nodout.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * @author: Milton Matias
 * Create: 15-02-2018
 * UpDate: 15-02-2018
 * Function: Oferecer as operações de consultas reacionadas a Clientes
 */

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	/**
	 * Function: Buscar um registro por id
	 * @param id
	 * @return cliente  
	 */
	public Cliente buscar(Integer id) {
		
		Cliente cliente =  repo.findOne(id);
		
		if(cliente == null) {
			// A camada de serviço recebe a exceção!
			throw new ObjectNotFoundException("Objeto não encontrado Id: "+ id
					+" Tipo: "+ Cliente.class.getName()); 
		}
		
		return 	cliente;
	}
	
}
