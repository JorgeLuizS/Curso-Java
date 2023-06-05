package com.algaworks.cursojava.financeiro.modelo;

import java.time.LocalDate;

public class ContaPagar extends Conta{
	private Fornecedor fornecedor;
	
	
	public ContaPagar() {
		super();
	}
	
	public ContaPagar(String descricao, double valor, LocalDate dataVencimento, Fornecedor fornecedor) {
		super(descricao, valor, dataVencimento);
		this.fornecedor = fornecedor;
	}
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	
	@Override
	public void pagar() {
		System.out.println(this);
		super.pagar();
		
		
	}
	
	public void cancelar() {
		System.out.println(this);
		super.cancelar();
		
	}
	
	
	@Override
	public String toString() {
		return "Conta a pagar\n"
				+ fornecedor 
				+ "\nDescrição: " + getDescricao()
				+ "\nValor: " + getValor()
				+ "\nData de vencimento: " + getDataVencimento() 
				+ "\nsituação da conta: "	+ getSituacaoConta() ;
	}

	
	
	
	

}
