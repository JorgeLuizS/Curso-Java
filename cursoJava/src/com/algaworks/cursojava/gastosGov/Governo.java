package com.algaworks.cursojava.gastosGov;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe para manipular e gerar relatórios sobre o gasto com cargos políticos
 * @author jorge
 *
 */
public class Governo {
	// armazena uma lista de políticos por estado da federação
	
		/**
		 * Map<String, List<Politico>>.
		 * Armazena os políticos (value) agrupando por partidos (key)
		 * Cada chave única representa um partido que agrupa politicos (List<Politico>). 
		 */
		private Map<String, List<Politico>> partidosPoliticos;
		
		

		/**
		 * Construtor. Inicializa o hashMap partidosPoliticos<String, List<Politico>>
		 */
		public Governo() {
			this.partidosPoliticos = new HashMap<String, List<Politico>>();
		}
		
		
		

		
		/**
		 * Adiciona um político (Político politico) a um partido (String partidoPolitico) ao hashMap partidoPolitico.
		 * Caso a chave informada não exista, será adicionada como um novo partido.
		 * @param partidoPolitico - Map<String, List<Politico>>.
		 * @param politico - classe Politico.
		 */
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
		 * Calcula os gastos com politicos dado um partido político.
		 * @param String 
		 * @return BigDecimal - toatal de gastos com partido político informado.
		 * @author jorge
		 * @apiNote Se a chave partido políco não existir em partidosPoliticos, retorna zero.
		 */
		public BigDecimal calcularGastosComSalario(String partidoPolitico) {
			BigDecimal valorTotal = new BigDecimal(0);
			List<Politico> politicos = null;
			
			// recupera a lista de políticos para um partido
			if((politicos = this.partidosPoliticos.get(partidoPolitico)) != null){
				for(Politico politico: politicos) {
					valorTotal = valorTotal.add(politico.getCargo().getSalario());
				}
				
			}
	
			return valorTotal;
			
		}
		
		
		/**
		 * Calcula os gastos de um partido político com um determinado cargo.
		 * @param Cargo 
		 * @param String 
		 * @return BigDecimal 
		 * @author jorge
		 * @apiNote Cargo é um atributo da classe Politico.
		 */
		public BigDecimal calcularGastosComSalarioParaCargo(Cargo cargo, String partidoPolitico) {
			BigDecimal valorTotal = new BigDecimal(0.0);
			
			List<Politico>politicos = this.findPoliticosByPartidoPoliticoAndCargo(cargo, partidoPolitico);
			
			for(Politico politico: politicos) {
				valorTotal = valorTotal.add(politico.getCargo().getSalario());
			}
			
			return valorTotal;
			
		}
		
		
		/**
		 * Obter uma lista de polícos que ocupam um determinado cargo em um partido político.
		 * @param Cargo
		 * @param String
		 * @return List<Politico>
		 */
		private List<Politico>findPoliticosByPartidoPoliticoAndCargo(Cargo cargo, String partidoPolitico){
			List<Politico>politicos = null;
			List<Politico>politicosCargo = new ArrayList<Politico>();
			
			if((politicos = this.partidosPoliticos.get(partidoPolitico)) != null) {
				for(Politico politico: politicos) {
					if(politico.getCargo() == cargo) {
						politicosCargo.add(politico);
					}
				}
			}
			
			return politicosCargo;
			
		}
		
		
		/**
		 * Listar os gastos por partido e por cargo.
		 */
		public void listarGastosPorPartido() {
			DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");
			
			List<Cargo>cargos = findAllCargos();
			List<String>partidos = findAllPartidosPoliticos();
			
			BigDecimal valorTotal = new BigDecimal(0);
			
			for(String partido: partidos) {
				
				System.out.println("Partido: " + partido + " - Cargos:");
				
				BigDecimal valorTotalPartido = new BigDecimal(0);
				
				for(Cargo cargo: cargos) {
					List<Politico>politicos = partidosPoliticos.get(partido);
					
					BigDecimal valorTotalCargo = new BigDecimal(0);
					for(Politico politico: politicos) {
			
						if(politico.getCargo() == cargo) {
							valorTotalCargo = valorTotalCargo.add(cargo.getSalario());
						}
					}
					
					System.out.println("\t" + cargo.getDescricao() + ": " + formatador.format(valorTotalCargo.doubleValue()));
					
					valorTotalPartido = valorTotalPartido.add(valorTotalCargo);
				}
				
				System.out.println("Total do partido: " + formatador.format( valorTotalPartido.doubleValue()) + "\n");
				
				valorTotal = valorTotal.add(valorTotalPartido);
				
			}
			
			System.out.println("Total geral: " + formatador.format( valorTotal.doubleValue()));
		}
		
		
		
		/**
		 * Obter um lista com todos os cargos inseridos em partidosPoliticos
		 * @return List<Cargo>
		 */
		private List<Cargo>findAllCargos(){
			 List<Cargo>cargos = new ArrayList<Cargo>();
			
			for(List<Politico> politicos: partidosPoliticos.values()){
				Cargo cargoAtual = null;

				for(Politico politico: politicos) {
					cargoAtual = politico.getCargo();
					if(!cargos.contains(cargoAtual)) {
						cargos.add(cargoAtual);
					}
										
				}
			}
			
			return cargos;
			
		}
		
		
		/**
		 * Obter uma lista de todos os partidos polícos armazenados em partidosPoliticos.
		 * @return List<String>
		 */
		public List<String>findAllPartidosPoliticos(){
			List<String>partidos = new ArrayList<String>();
			
			for(String partido: partidosPoliticos.keySet()) {
				partidos.add(partido);
			}
			
			return partidos;
			
		}
		
		
		/**
		 * Obter, a partir de partidosPoliticos, a lista de todos os politicos que ocupam um determinado cargo.
		 * @param politicos
		 * @param cargo
		 * @return
		 */
		public List<Politico>findPoliticosByCargo(List<Politico> politicos, Cargo cargo){
			List<Politico>politicosCargo = new ArrayList<Politico>();
			
			for(Politico politico: politicos) {
				if(politico.getCargo().equals(cargo)) {
					politicosCargo.add(politico);
				}
			}
			
			return politicosCargo;
		}

}

