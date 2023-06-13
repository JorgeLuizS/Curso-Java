package com.algaworks.cursojava.gastosGov;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Governo2 {
	// armazena uma lista de políticos por estado da federação
		private Map<String, List<Politico>> partidosPoliticos;
		
		

		public Governo2() {
			this.partidosPoliticos = new HashMap<String, List<Politico>>();
		}
		
		
		

		public void adicionarPolitico(String partidoPolitico, Politico politico) {
			// recupera a lista de políticos para um partido
			List<Politico> politicos = this.partidosPoliticos.get(partidoPolitico);
			
			// se não existir uma lista de políticos para o partido informado,
			// devemos instanciar uma nova lista (pois é a primeira inclusão neste partido)
			if (politicos == null) {
				politicos = new ArrayList<Politico>();
			}
			
			// adiciona o político recebido como parâmetro à lista de políticos
			politicos.add(politico);
			
			// adiciona a lista de políticos ao mapa de partidos usando
			// como chave o nome do partido
			this.partidosPoliticos.put(partidoPolitico, politicos);
		}

		
		/**
		 * 
		 * @param String partidoPolitico
		 * @return BigDecimal
		 * @author jorge
		 * @apiNote Calcula os gastos com politicos dado um partido político.
		 */
		public BigDecimal calcularGastosComSalario(String partidoPolitico) {
		
			// recupera a lista de políticos para um partido
			List<Politico> politicos = this.partidosPoliticos.get(partidoPolitico);
			
			if(politicos == null) {
				return null;
			}
			
			BigDecimal valorTotal = new BigDecimal(0);
			for(Politico politico: politicos) {
				valorTotal.add(politico.getCargo().getSalario());
			}
			
			return valorTotal;
			
		}
		
		
		/**
		 * 
		 * @param cargo
		 * @param partidoPolitico
		 * @return BigDecimal 
		 * @author jorge
		 * @apiNote Calcula gastos com um partido político para um determinado cargo.
		 */
		public BigDecimal calcularGastosComSalarioParaCargo(Cargo cargo, String partidoPolitico) {
			BigDecimal valorTotal = new BigDecimal(0.0);
			List<Politico> politicos = null;
			
			//Tentar obter os políticos do partido político passado no parâmetro 2.
			if((politicos = this.partidosPoliticos.get(partidoPolitico)) != null) {	//Caso encontre...
				//Navega pela lista de polícos obtida para procurar pelo cargo passado no parâmetro 1.
				for(Politico politico: politicos) {
					if(politico.getCargo() == cargo){	//Se encontrar o cargo...
						valorTotal.add(cargo.getSalario());
					}
				}
				
			}
			
			return valorTotal;
			
		}
		
		
		
		private List<Politico>findPoliticosByPartidoPolitico(String partidoPolitico){
			List<Politico> politicos;
			
			return this.partidosPoliticos.get(partidoPolitico);
			
			
		}
		
		

}

