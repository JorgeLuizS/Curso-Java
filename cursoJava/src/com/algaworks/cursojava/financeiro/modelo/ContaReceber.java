package com.algaworks.cursojava.financeiro.modelo;

import java.time.LocalDate;

public class ContaReceber extends Conta{
	Cliente cliente;
	
	
	public ContaReceber() {
		super();
	}
	
	
	public ContaReceber(Cliente cliente, String descricao, double valor, LocalDate dataVencimento) {
		super();
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setDataVencimento(dataVencimento);
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
	public void cancelar() {
		String mensagem = this.toString();
		
		final double VALOR_MAXIMO = 50000d;
		
		
		if(this.getValor() <= VALOR_MAXIMO) {
				this.situacaoConta = SituacaoConta.PAGA;
				mensagem += "\n>> Recebida com sucesso <<";
		}else {
				mensagem += "\n>> Não foi possível cancelar esta conta <<"
						+ "\n\tMotivo: valor acima de " + VALOR_MAXIMO;
		}
		
		System.out.println(mensagem + "\nStatus atual da conta: " + situacaoConta + "\n");
		
	}
	
	

	public void receber() {
		String mensagem = this.toString();
		
		if(this.getSituacaoConta() == SituacaoConta.PENDENTE) {
			this.situacaoConta = SituacaoConta.PAGA;
			
			mensagem += "\n>> recebida com sucesso <<";
		}else {
			mensagem += "\n>> não pôde ser recebida <<";
		}
		
		System.out.println(mensagem  + "\nStatus atual da conta: " + situacaoConta + "\n");
	}

	
	
	@Override
	public  void exibirDetalhes() {
		System.out.printf("Conta a receber\t, %-40s, %-48s, %9.2f, %s, %8s\n",
				this.cliente.getNome(),
				this.getDescricao(),
				this.getValor(),
				this.getDataVencimento().toString(),
				this.getSituacaoConta()
				);
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
