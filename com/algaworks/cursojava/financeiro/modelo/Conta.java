package com.algaworks.cursojava.financeiro.modelo;

import java.time.LocalDate;

public class Conta {
	
	private String descricao;
	private double valor;
	private LocalDate dataVencimento;
	private SituacaoConta situacaoConta;
	
	
	/**
	 * Construtores
	 */
	public Conta(){
		this.situacaoConta = SituacaoConta.PENDENTE;
	}
	

	public Conta(String descricao, double valor, LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
		this.descricao = descricao;
		this.valor = valor;
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


	/*
	 * Outros métodos.
	 */
	public void pagar() {
		if(this.situacaoConta == SituacaoConta.PENDENTE) {
			this.situacaoConta = SituacaoConta.PAGA;
			System.out.println(">> A conta foi PAGA com sucesso <<");
		}else {
			System.out.println(">> Não foi possível realizar o pagamento desta conta <<");
		}
		
		System.out.println("Situaçao atual da conta: " + situacaoConta + "\n");
	}
	
	
	
	public void cancelar() {
		if(this.situacaoConta == SituacaoConta.PENDENTE) {
			this.situacaoConta = SituacaoConta.CANCELADA;
			System.out.println(">> A conta foi CANCELADA com sucesso <<");
		}else {
			System.out.println("Não foi possível realizar o cancelamento desta conta ");
		}
		
		System.out.println("Situaçao atual da conta: " + situacaoConta + "\n");
	}


	@Override
	public String toString() {
		return "Conta [descricao=" + descricao + ", valor=" + valor + ", dataVencimento=" + dataVencimento
				+ ", situacaoConta=" + situacaoConta + "]";
	}


	
}
