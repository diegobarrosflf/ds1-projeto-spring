package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemAluguelPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "aluguel_id")
	private Aluguel aluguel;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluguel == null) ? 0 : aluguel.hashCode());
		result = prime * result + ((filme == null) ? 0 : filme.hashCode());
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
		ItemAluguelPK other = (ItemAluguelPK) obj;
		if (aluguel == null) {
			if (other.aluguel != null)
				return false;
		} else if (!aluguel.equals(other.aluguel))
			return false;
		if (filme == null) {
			if (other.filme != null)
				return false;
		} else if (!filme.equals(other.filme))
			return false;
		return true;
	}

}
