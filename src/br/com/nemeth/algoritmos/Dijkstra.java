package br.com.nemeth.algoritmos;

import java.util.List;
import java.util.Vector;

import br.com.nemeth.Aresta;
import br.com.nemeth.Grafo;

public class Dijkstra {

//	Inicializar todos os v�rtices como aberto
//	Inicializar todos os v�rtices como sem v�rtice anterior
//	Inicializar todos os v�rtices como dist�ncia infinita
//	Definir o v�rtice inicial como v�rtice atual
//	Definir a dist�ncia do v�rtice atual como zero
//	Enquanto existir algum v�rtice aberto com dist�ncia n�o infinita
//	       Para cada vizinhos do v�rtices atual
//	              Se a dist�ncia do vizinho � maior que a dist�ncia do v�rtice atual mais o peso da aresta que os une
//			Atribuir esta nova dist�ncia ao vizinho
//			Definir como v�rtice anterior deste vizinho o v�rtice atual
//	       Marcar o v�rtice atual como fechado
//	       Definir o v�rtice aberto com a menor dist�ncia (n�o infinita) como o v�rtice atual

	
	  public void execute(Grafo grafo, Aresta inicial ) {
		 
		  int qtd = grafo.vertices.size();
		  List<Boolean> aberto = new Vector<Boolean>();
		  List<Double> distancia = new Vector<Double>();
		  // inicializando vertices e distancia infinita
		for (int i = 0; i < qtd; i++) {
			aberto.add(true);
			distancia.add(Double.MAX_VALUE);
		}
//		  grafo.
		  
		  
	}
}
