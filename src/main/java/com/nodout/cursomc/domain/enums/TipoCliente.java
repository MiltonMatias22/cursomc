package com.nodout.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOA_FISICA(1, "PESSOA FÍSICA"),
	PESSOA_JURIDICA(2, "PESSOA JURÍDICA");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCliente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		
		if(codigo == null ) {
			return null;
		}
		
		for(TipoCliente tipoCliente: TipoCliente.values()) {
			if(codigo.equals(tipoCliente.getCodigo())) {
				return tipoCliente;
			}		
		}
				
		throw new IllegalArgumentException("ID: "+codigo+" inválido!");
		
	}
	
}
