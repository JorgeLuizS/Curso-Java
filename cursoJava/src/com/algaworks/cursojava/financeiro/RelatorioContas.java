package com.algaworks.cursojava.financeiro;

import com.algaworks.cursojava.financeiro.modelo.Conta;
import com.algaworks.cursojava.financeiro.modelo.ContaPagar;
import com.algaworks.cursojava.financeiro.modelo.ContaReceber;

public class RelatorioContas {
	
	public void exibirListagem(Conta[] contas) {
		System.out.println("RELATÓRIO DE CONTAS");
		System.out.printf("%s\t, %-40s, %-48s, %9s, %s, %s\n"
				,"TIPO DA CONTA"
				,"FORNECEDOR/CLIENTE"
				,"DESCRIÇÃO"
				,"VALOR"
				,"VENCIMENTO"
				,"SITUAÇÃO");
		
		for(Conta conta: contas) {
			conta.exibirDetalhes();
		}
		

		System.out.println("-".repeat(141));
		
		System.out.printf("Saldo (diferença entre contas a receber - contas a pagar: %13.2f\n", this.totalizarMovimento(contas));
	}
	
	public double totalizarMovimento(Conta[] contas) {
		double valorTotal = 0d;
		
		for(Conta conta: contas) {
			if(conta instanceof ContaPagar) {
				valorTotal -= conta.getValor();
			}else if(conta instanceof ContaReceber) {
				valorTotal += conta.getValor();
			}
		}
		
		return valorTotal;
	}
	

}
