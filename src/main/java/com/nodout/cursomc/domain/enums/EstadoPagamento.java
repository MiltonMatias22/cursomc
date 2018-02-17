package com.nodout.cursomc.domain.enums;

/**
 * @author: Milton Matias
 * Create: 17-02-2018
 * UpDate: 17-02-2018
 */
public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private Integer codigo;
	private String descricao;
	
	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
public static EstadoPagamento toEnum(Integer codigo) {
		
		if(codigo == null ) {
			return null;
		}
		
		for(EstadoPagamento estadoPagamento: EstadoPagamento.values()) {
			if(codigo.equals(estadoPagamento.getCodigo())) {
				return estadoPagamento;
			}		
		}
				
		throw new IllegalArgumentException("ID: "+codigo+" inválido!");
		
	}
	

}
