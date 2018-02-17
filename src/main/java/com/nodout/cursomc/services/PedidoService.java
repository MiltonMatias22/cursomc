package com.nodout.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodout.cursomc.domain.Pedido;
import com.nodout.cursomc.repositoreis.PedidoRepository;
import com.nodout.cursomc.services.exceptions.ObjectNotFoundException;

/**
 * @author: Milton Matias
 * Create: 17-02-2018
 * UpDate: 17-02-2018
 * Function: Oferecer as operações de consultas reacionadas a Pedidos
 */

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	/**
	 * Function: Buscar um registro por id
	 * @param id
	 * @return pedido  
	 */
	public Pedido buscar(Integer id) {
		
		Pedido pedido =  repo.findOne(id);
		
		if(pedido == null) {
			// A camada de serviço recebe a exceção!
			throw new ObjectNotFoundException("Objeto não encontrado Id: "+ id
					+" Tipo: "+ Pedido.class.getName()); 
		}
		
		return 	pedido;
	}
	
}
