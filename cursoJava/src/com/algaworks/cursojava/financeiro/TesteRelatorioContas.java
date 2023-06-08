package com.algaworks.cursojava.financeiro;

import java.time.LocalDate;

import com.algaworks.cursojava.financeiro.modelo.Cliente;
import com.algaworks.cursojava.financeiro.modelo.Conta;
import com.algaworks.cursojava.financeiro.modelo.ContaPagar;
import com.algaworks.cursojava.financeiro.modelo.ContaReceber;
import com.algaworks.cursojava.financeiro.modelo.Fornecedor;

public class TesteRelatorioContas {

	public static void main(String[] args) {
		// instanciando fornecedores
		Fornecedor imobiliaria = new Fornecedor();
		imobiliaria.setNome("Casa & Cia Negócios Imobiliários");
		Fornecedor mercado = new Fornecedor();
		mercado.setNome("Mercado do João");
		
		// instanciando clientes
		Cliente atacadista = new Cliente();
		atacadista.setNome("Triângulo Quadrado Atacadista");
		Cliente telecom = new Cliente();
		telecom.setNome("FoneNet Telecomunicações");
		
		// instanciando contas a pagar
		ContaPagar contaPagar1 = new ContaPagar();
		contaPagar1.setDescricao("Aluguel da matriz");
		contaPagar1.setValor(1230d);
		contaPagar1.setDataVencimento(LocalDate.of(2012, 5, 10));
		contaPagar1.setFornecedor(imobiliaria);
		
		ContaPagar contaPagar2 = new ContaPagar(mercado, "Compras do mês", 390d, LocalDate.of(2012, 5, 19));
		
		// instanciando contas a receber
		ContaReceber contaReceber1 = new ContaReceber();
		contaReceber1.setDescricao("Desenvolvimento de projeto de logística em Java");
		contaReceber1.setValor(89500d);
		contaReceber1.setDataVencimento(LocalDate.of(2012, 5, 23));
		contaReceber1.setCliente(atacadista);
		
		ContaReceber contaReceber2 = new ContaReceber(telecom, "Manutenção em sistema de conta online", 
			53200d, LocalDate.of(2012, 5, 13));
		
		// exibe listagem de todas as contas com detalhamento
		RelatorioContas relatorio = new RelatorioContas();
		Conta[] contas = new Conta[]{contaPagar1, contaPagar2, contaReceber1, contaReceber2};
		
		relatorio.exibirListagem(contas);
	}
	
}
