package com.algaworks.cursojava.financeiro.modelo;

public class Cliente extends Pessoa{

	@Override
	public String toString() {
		return "Cliente\n"
				+ "Nome: " + this.getNome();
	}
	
	

}
