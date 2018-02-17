package com.nodout.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author: Milton Matias
 * Create: 17-02-2018
 * UpDate: 17-02-2018
 */
@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date instante;
	
	/** CascadeType.ALL: necessário para evitar erro de entidade transiente
	 *  quando for salvar o pedido e pagamento.
	 * */
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	/** endpont de Pedidos:
	 * @JsonManagedReference: permite que um Cliente de um pedido seja
	 * Serializado, mas ñ o contrário, evitando referência cíclica (loop). uma vez
	 * que para mostrar um Cliente deve ser feito uma busca pelos seus pedidos,
	 * e para mostrar os pedidos deve tb ser feito uma busca pelos clientes
	 * associados aos mesmos (loop). 
	 *  */
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	/** Relação direcionada o Pedido conhece o Endereco, mas não o contrário*/
	@ManyToOne
	@JoinColumn(name = "endereco_entrega_id")
	private Endereco enderecoEntrega;
	
	/** Um Pedido conhece os itemPedidos associados a ele.
	 * mappedBy: "id.pedido": mapeado pelo atributo (ItemPedidoPK id) na
	 * classe ItemPedido que tem a referência para o pedido.
	 * */
	@JsonManagedReference
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itemPedidos = new HashSet<>();
	
	/**Construdo Padrão */
	public Pedido() {
		
	}

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoEntrega) {
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(Set<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
