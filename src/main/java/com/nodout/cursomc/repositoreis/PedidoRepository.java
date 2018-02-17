package com.nodout.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nodout.cursomc.domain.Pedido;

/**
 * @author: Milton Matias
 * Create: 17-02-2018
 * UpDate: 17-02-2018 
 */

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
