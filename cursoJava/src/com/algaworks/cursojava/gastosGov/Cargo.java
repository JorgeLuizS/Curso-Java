package com.algaworks.cursojava.gastosGov;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Dados de um cargo.
 * @author jorge
 *
 */
public class Cargo {
	private String descricao;
	private BigDecimal salario;
	
	
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getSalario() {
		return this.salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(descricao, other.descricao);
	}
	
	


}
