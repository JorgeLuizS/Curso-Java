package com.algaworks.cursojava.gastosGov;

import java.math.BigDecimal;

/**
 * Testar a utilização da classe Governo.
 * @author jorge
 *
 */
public class TesteGastosGov {
	public static void main(String[] args) {
		// instancia governo
		Governo governo = new Governo();
		
		// instancia cargos
		Cargo vereador = new Cargo();
		vereador.setDescricao("Vereador");
		vereador.setSalario(new BigDecimal(16000));
		
		Cargo deputadoEstadual = new Cargo();
		deputadoEstadual.setDescricao("Deputado estadual");
		deputadoEstadual.setSalario(new BigDecimal(25000));
		
		Cargo prefeito = new Cargo();
		prefeito.setDescricao("Prefeito");
		prefeito.setSalario(new BigDecimal(27000));
		
		// adiciona vereadores
		Politico politico = new Politico();
		politico.setNome("João das Couves");
		politico.setCargo(vereador);
		governo.adicionarPolitico("RBLH", politico);
		
		politico = new Politico();
		politico.setNome("Zé Mané");
		politico.setCargo(vereador);
		governo.adicionarPolitico("PCOR", politico);
		
		politico = new Politico();
		politico.setNome("Maria Carvalho");
		politico.setCargo(vereador);
		governo.adicionarPolitico("LDRS", politico);
		
		politico = new Politico();
		politico.setNome("Maria Carvalho");
		politico.setCargo(vereador);
		governo.adicionarPolitico("LDRS", politico);
		
		// adiciona deputados estaduais
		politico = new Politico();
		politico.setNome("Josefa Silva");
		politico.setCargo(deputadoEstadual);
		governo.adicionarPolitico("LDRS", politico);
		
		politico = new Politico();
		politico.setNome("Fátima Gonçalves");
		politico.setCargo(deputadoEstadual);
		governo.adicionarPolitico("PCOR", politico);
		
		// adiciona prefeito
		politico = new Politico();
		politico.setNome("Sebastião Mendes");
		politico.setCargo(prefeito);
		governo.adicionarPolitico("PCOR", politico);
		
		politico = new Politico();
		politico.setNome("Cezar Carvalho");
		politico.setCargo(prefeito);
		governo.adicionarPolitico("PRAT", politico);
		
		politico = new Politico();
		politico.setNome("Jonny Bravo");
		politico.setCargo(vereador);
		governo.adicionarPolitico("PRAT", politico);
		
		politico = new Politico();
		politico.setNome("Armando Treta");
		politico.setCargo(deputadoEstadual);
		governo.adicionarPolitico("VGBNDS", politico);
		
		
		governo.listarGastosPorPartido();
		
	}

}
