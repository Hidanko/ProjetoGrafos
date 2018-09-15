package br.com.nemeth.algoritmos;

import java.util.List;
import java.util.Vector;

import br.com.nemeth.Aresta;
import br.com.nemeth.Grafo;

public class Dijkstra {

//	Inicializar todos os vértices como aberto
//	Inicializar todos os vértices como sem vértice anterior
//	Inicializar todos os vértices como distância infinita
//	Definir o vértice inicial como vértice atual
//	Definir a distância do vértice atual como zero
//	Enquanto existir algum vértice aberto com distância não infinita
//	       Para cada vizinhos do vértices atual
//	              Se a distância do vizinho é maior que a distância do vértice atual mais o peso da aresta que os une
//			Atribuir esta nova distância ao vizinho
//			Definir como vértice anterior deste vizinho o vértice atual
//	       Marcar o vértice atual como fechado
//	       Definir o vértice aberto com a menor distância (não infinita) como o vértice atual

	
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
