package com.algaworks.cursojava.financeiro.modelo;

import java.time.LocalDate;

public class ContaPagar extends Conta{
	private Fornecedor fornecedor;

	
	
	public ContaPagar() {
		super();
	}
	
	public ContaPagar(Fornecedor fornecedor, String descricao, double valor, LocalDate dataVencimento) {
		super();
		
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setDataVencimento(dataVencimento);
		this.fornecedor = fornecedor;
	}
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	
	/*
	 * Outros métodos.
	 */
	public void pagar() {
		String mensagem = this.toString();
		
		if(this.situacaoConta == SituacaoConta.PENDENTE) {
			this.situacaoConta = SituacaoConta.PAGA;
			mensagem += "\n>> PAGA com sucesso <<";
		}else {
			mensagem += "\n>> Não foi possível realizar o pagamento desta conta <<";
		}
		
		
		System.out.println(mensagem + "\nSituaçao atual da conta: " + situacaoConta + "\n");
	}
	
	
	
	public void cancelar() {
		String mensagem = this.toString();
		
		if(this.situacaoConta == SituacaoConta.PENDENTE) {
			this.situacaoConta = SituacaoConta.CANCELADA;
			mensagem += "\n>> A conta foi CANCELADA com sucesso <<";
		}else {
			mensagem += "Não foi possível realizar o cancelamento desta conta ";
		}
		
		System.out.println(mensagem + "\nSituaçao atual da conta: " + situacaoConta + "\n");
	}
	
	
	
	
	@Override
	public  void exibirDetalhes() {
		System.out.printf("Conta a pagar\t, %-40s, %-48s, %9.2f, %10s, %8s\n",
				this.fornecedor.getNome(),
				this.getDescricao(),
				this.getValor(),
				this.getDataVencimento().toString(),
				this.getSituacaoConta()
				);
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
