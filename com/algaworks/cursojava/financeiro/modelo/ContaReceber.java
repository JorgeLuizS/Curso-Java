package com.algaworks.cursojava.financeiro.modelo;

import java.time.LocalDate;

public class ContaReceber extends Conta{
	Cliente cliente;
	
	
	public ContaReceber() {
		super();
	}
	
	public ContaReceber(String descricao, double valor, LocalDate dataVencimento, Cliente cliente) {
		super(descricao, valor, dataVencimento);
		this.cliente = cliente;
	}



	
	/*
	 * Getters & Setters
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	/*
	 * Outros métodos
	 */
	@Override
	public void cancelar() {
		System.out.println(this);
		
		final double valorMaximo = 50000d;
		String mensagem = null;
		
		
		if(this.getValor() <= valorMaximo) {
				super.cancelar();
		}else {
				mensagem = ">> Não foi possível cancelar esta conta <<"
						+ "\n\tMotivo: valor acima de " + valorMaximo;
		}
		
		System.out.println(mensagem + "\n");
		
	}
	
	

	public void receber() {
		System.out.println(this);
		pagar();
		
	}

	@Override
	public String toString() {
		return "Conta a receber\n"
				+ cliente
				+ "\nDescrição: " + getDescricao()
				+ "\nValor: " + getValor()
				+ "\nData de vencimento: " + getDataVencimento()
				+ "\nsituação da conta: " + getSituacaoConta();
	}

	
	
	
}
