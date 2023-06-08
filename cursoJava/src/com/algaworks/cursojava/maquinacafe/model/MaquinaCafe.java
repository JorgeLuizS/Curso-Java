package com.algaworks.cursojava.maquinacafe.model;

public class MaquinaCafe {
	private int acucarDisponivel;
	
	public MaquinaCafe(int acucarDisponivel) {
		this.acucarDisponivel = acucarDisponivel;
	}
	
	

	public int getAcucarDisponivel() {
		return acucarDisponivel;
	}

	public void setAcucarDisponivel(int acucarDisponivel) {
		this.acucarDisponivel = acucarDisponivel;
	}

	
	
	
	public void fazerCafe(int quantidadeAcucar) {
		if (acucarDisponivel < quantidadeAcucar) {
			System.out.println("Não há açucar suficiente para fazer seu café.");
		} else {
			acucarDisponivel -= quantidadeAcucar;
			System.out.println("Fazendo cafezinho com " + quantidadeAcucar + " gramas de açucar.");
		}
	}
	
	
	public void fazerCafe() {
		fazerCafe(10);
	}



	public void carregarAcucar(int quantidadeAcucar) {
		this.acucarDisponivel += quantidadeAcucar;
		
		System.out.println("");
		
	}
	
	
	
	
}
