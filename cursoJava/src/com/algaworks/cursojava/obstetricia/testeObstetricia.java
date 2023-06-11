package com.algaworks.cursojava.obstetricia;

import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Locale;

public class testeObstetricia {

		public static void main(String args[]) {
			new testeObstetricia();
		}
		
		
		
		public testeObstetricia() {
			Scanner entrada = new Scanner(System.in);

			try {
				System.out.println("Data do último período menstrual (dd/mm/aaaa):");
				String ultimoPeriodoMenstrual = entrada.nextLine();

				Date dataUltimoPeriodoMenstrual = this.converterEmData(ultimoPeriodoMenstrual);
				CalculadoraGravidez calculadora = new CalculadoraGravidez(dataUltimoPeriodoMenstrual);

				
				System.out.println("Data fornecida: " 
					+ this.formatarData(dataUltimoPeriodoMenstrual));
				
				Date dataEstimadaConcepcao = calculadora.calcularDataEstimadaConcepcao();
				System.out.println("Data estimada da concepção: " 
					+ this.formatarData(dataEstimadaConcepcao));

				Date dataEstimadaParto = calculadora.calcularDataEstimadaParto();
				System.out.println("Data estimada para parto: " 
					+ this.formatarData(dataEstimadaParto));			
			} catch (ParseException pe) {
				System.out.println("Informe uma data no padrão dd/mm/aaaa.");
			}finally {
				entrada.close();
				System.out.println("Programa terminado.");
			}
		}
		
		private String formatarData(Date data) {
			// Padrão de formatação de data por extenso
			// A classe Locale representa uma região no planeta, sendo neste caso
			// o Brasil (br), onde falamos Português (pt)
			// O Locale é usado aqui para formatar a data em português brasileiro
			DateFormat formatador = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy" , new Locale("pt", "br") );
			return formatador.format(data);
		}
		
		private Date converterEmData(String texto) throws ParseException {
			DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "br"));
			return formatador.parse(texto);
		}


}
