package com.nodout.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nodout.cursomc.domain.Categoria;

/**
 * @author: Milton Matias
 * Create: 15-02-2018
 * UpDate: 15-02-2018
 * Function: Realizar operações de acesso a dados referêntes ao objeto da Classe Categoria,
 *                 Que está mapeado com a tabela Categoria na base de dados.
 *                 JpaRepository <tipoObjeto, tipoIndentificador>.  
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
