package com.nodout.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.nodout.cursomc.domain.enums.EstadoPagamento;

/**
 * @author: Milton Matias
 * Create: 17-02-2018
 * UpDate: 17-02-2018
 */

@Entity
public class PagamentoComBoleto extends Pagamento{
	/**Erda implements Serializable da superclasse, precisa somente o
	 * do nímero de versão.
	 * */
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	/** Como PagamentoComBoleto é uma subclasse seu construtor com parâmentros
	 *  deve ser gerado com: Generate contructor from superclass.
	 *  isso irá fazer com que somente os atributos da superclasse sejatados no contrutor
	 *  com parâmetros. Após isso, prencher o construtor com os parâmentros faltantes da
	 *  subclasse. 
	 * */
	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,
			Date dataVencimento, Date dataPagamento) {
		super(id, estadoPagamento, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
}
