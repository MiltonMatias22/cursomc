package com.nodout.cursomc.domain;

import javax.persistence.Entity;

import com.nodout.cursomc.domain.enums.EstadoPagamento;

/**
 * @author: Milton Matias
 * Create: 17-02-2018
 * UpDate: 17-02-2018
 */

@Entity
public class PagamentoComCartao extends Pagamento{
	/**Erda implements Serializable da superclasse, precisa somente o
	 * do nímero de versão.
	 * */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,
			Integer numeroParcelas) {
		super(id, estadoPagamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
