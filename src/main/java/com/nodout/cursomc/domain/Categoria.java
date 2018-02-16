package com.nodout.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author: Milton Matias
 * @crida: 15-02-2018
 * @modificada: 15-02-2018
 * @version: V1.0
 */

@Entity
public class Categoria implements Serializable{
	
	/**
	 * @Serializable: Para o objeto ser gravado em arquivos
	 * ou ser trafegado via internet.
	 * @serialVersionUID = 1L: 1L = Primeira versão da classe Categoria.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos básico da classe.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private String nome;
	
	/** Relacionamento: Categorias (1, *)-----(0, *) Produto = N to N
	 *  mappedBy: Mapeamento feito pela outra classe associada,
	 *  Produto, em cima do atributo categorias.
	 *  @JsonManagedReference: Fazer do lado que vc quer que venha os
	 *  objetos associados. Ex: Ao buscar uma categoria, tb buscar os prduutos
	 *  relacionados a ela. E @JsonBackReference do outro lado da associação
	 */
	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias") 
	private List<Produto> produtos = new ArrayList<>();
	
	/**
	 * Construtor vazio
	 */
	public Categoria() {		
	}
	
	/**
	 * @param id: Identificado único da classe.
	 * @param nome: Descrição da categoria.
	 */	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	/** GETTERS AND SETTERS */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
			
	/** HASHCODE AND EQUALS: para comparar objetos!*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
