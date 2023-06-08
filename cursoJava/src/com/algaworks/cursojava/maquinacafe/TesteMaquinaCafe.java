package com.algaworks.cursojava.maquinacafe;

import com.algaworks.cursojava.maquinacafe.model.MaquinaCafe;

public class TesteMaquinaCafe {

	public static void main(String[] args) {
		
		MaquinaCafe maquina = new MaquinaCafe(30);

		maquina.fazerCafe(10);
		maquina.fazerCafe(15);

		// faz cafe com a quantidade de açúcar padrão
		// não será possível fazer esse cafezinho, pois a máquina
		// só tinha 30gr de açúcar disponível
		maquina.fazerCafe();
		
		maquina.carregarAcucar(40);

	}

}
