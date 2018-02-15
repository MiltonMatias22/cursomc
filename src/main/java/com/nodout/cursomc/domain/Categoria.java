package com.nodout.cursomc.domain;

import java.io.Serializable;

/**
 * @author: Milton Matias
 * @crida: 15-02-2018
 * @modificada: 15-02-2018
 * @version: V1.0
 */

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
	private Integer id;	
	
	private String nome;
	
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
	
	
	/** HASHCODE AND EQUALS: para comparar objetos!*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
