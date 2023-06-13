package com.algaworks.cursojava.gastosGov;

/**
 * Classe para os dados de um político.
 * @author jorge
 *
 */
public class Politico {
	private String nome;
	private Cargo cargo;
	
	
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cargo getCargo() {
		return this.cargo;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
