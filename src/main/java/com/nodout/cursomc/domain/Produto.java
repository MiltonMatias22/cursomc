package com.nodout.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author: Milton Matias
 * Create: 16-02-2018
 * UpDate: 16-02-2018
 */

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	/** Relacionamento: Categorias (1, *)-----(0, *) Produto
	 *  @JsonBackReference: Do outro lado da associação os obejtos produtos já foram buscados,
	 *  com isso impedindo que aja novas bucas ocasionando a referencia cíclica (loop de buscas).
	 *  omitindo a lista de categorias para cada produto.
	 * */
	@JsonBackReference
	@ManyToMany
	@JoinTable(	
			name = "PRODUTO_CATEGRIA", // Nova tabela N para N
			joinColumns = @JoinColumn(name = "produto_id"), // Foreign key dessa tabela Produto
			inverseJoinColumns = @JoinColumn(name = "categoria_id") // Foreign key da outra tabale Categoria
			)
	private List<Categoria> categorias = new ArrayList<>();
	
	/** Um Produto conhece is itemPedidos a qual está associado 
	 * mappedBy: "id.produto": mapeado pelo atributo (ItemPedidoPK id) na
	 * classe ItemPedido que tem a referência para o Produto.
	 * */
	@JsonIgnore // Ignorar Serialização da lista item
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itemPedidos = new HashSet<>();
	
	/** Contrutor padrão */
	public Produto() {
	
	}	
	
	/** Contrutor com parametros */
	public Produto(Integer id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	/**
	 * Function:  Varre uma lista  Set<ItemPedido> e Monta uma lista de pedidos
	 * no qual o produto está associado.
	 * @return pedidos:
	 * */
	@JsonIgnore // Ignorar Serialização da lista de pedis
	public List<Pedido> getPedidos(){
		
		List<Pedido> pedidos = new ArrayList<>();
		
		/** Para cada itemPedido do conjubto Set<itemPediddos>...*/
		for(ItemPedido itemPedido : this.itemPedidos)	{
			/** add a lista de pedidos o pedido*/
			pedidos.add(itemPedido.getPedido());
			
		}
		
		return pedidos;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(Set<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		

}
