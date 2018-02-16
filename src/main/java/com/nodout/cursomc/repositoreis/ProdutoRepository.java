package com.nodout.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nodout.cursomc.domain.Produto;

/**
 * @author: Milton Matias
 * Create: 16-02-2018
 * UpDate: 16-02-2018
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
