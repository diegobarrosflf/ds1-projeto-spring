package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemAluguel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemAluguelPK id = new ItemAluguelPK();
	
	private Integer desconto;
	private int quantidade;
	private Double preco;
	
	public ItemAluguel() {
		
	}

	public ItemAluguel(Aluguel aluguel, Filme filme, Integer desconto, int quantidade) {
		super();
		this.id.setAluguel(aluguel);
		this.id.setFilme(filme);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = filme.getPreco();
	}
	
	public Aluguel getAluguel() {
		return id.getAluguel();
	}
	
	public Filme getFilme() {
		return id.getFilme();
	}

	public ItemAluguelPK getId() {
		return id;
	}

	public void setId(ItemAluguelPK id) {
		this.id = id;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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
		ItemAluguel other = (ItemAluguel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
