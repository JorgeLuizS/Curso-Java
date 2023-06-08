package com.algaworks.cursojava.financeiro.modelo;

import java.time.LocalDate;

public abstract class Conta {
	
	private String descricao;
	private double valor;
	private LocalDate dataVencimento;
	protected SituacaoConta situacaoConta;
	
	
	/**
	 * Construtores
	 */
	public Conta(){
		this.situacaoConta = SituacaoConta.PENDENTE;
	}
		
	
	
	/*
	 * Getters & setters
	 */
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}


	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}



	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}



	public abstract void exibirDetalhes();
	

	/*
	 * @Override public String toString() { return "Conta [descricao=" + descricao +
	 * ", valor=" + valor + ", dataVencimento=" + dataVencimento +
	 * ", situacaoConta=" + situacaoConta + "]"; }
	 */



	
}
