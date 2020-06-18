package com.example.demo.domain;

import javax.persistence.Entity;

import com.example.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCredito extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer parcelas;

	public PagamentoCredito() {

	}

	public PagamentoCredito(Integer id, EstadoPagamento estado, Aluguel aluguel, Integer parcelas) {
		super(id, estado, aluguel);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
