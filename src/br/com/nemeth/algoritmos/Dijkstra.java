package br.com.nemeth.algoritmos;

import java.util.List;
import java.util.Vector;

import br.com.nemeth.grafo.Aresta;
import br.com.nemeth.grafo.Grafo;

public class Dijkstra {

	// Inicializar todos os vértices como aberto
	// Inicializar todos os vértices como sem vértice anterior
	// Inicializar todos os vértices como distância infinita
	// Definir o vértice inicial como vértice atual
	// Definir a distância do vértice atual como zero
	// Enquanto existir algum vértice aberto com distância não infinita
	// Para cada vizinhos do vértices atual
	// Se a distância do vizinho é maior que a distância do vértice atual mais o
	// peso da aresta que os une
	// Atribuir esta nova distância ao vizinho
	// Definir como vértice anterior deste vizinho o vértice atual
	// Marcar o vértice atual como fechado
	// Definir o vértice aberto com a menor distância (não infinita) como o vértice
	// atual

	public static void execute(Grafo grafo, int inicial) {

		int qtd = grafo.vertices.size();
		List<Boolean> aberto = new Vector<Boolean>();
		List<String> anterior = new Vector<String>();
		List<Double> distancia = new Vector<Double>();
		// inicializando vertices e distancia infinita
		for (int i = 0; i < qtd; i++) {
			aberto.add(true);
			anterior.add(null);
			distancia.add(Double.MAX_VALUE);
		}
		// definir a distancia atual como zero
		distancia.set(inicial, 0.0);
		int numAbertos = 0;
		// enquanto exisitr algum vertice aberto
		while (numAbertos >= qtd) {
			int i = numAbertos;
			// ignorar o inicial
			if (i != inicial) {

				int menorDistancia = -1;
				// para cada vizinho do vertice
				for (int j = 0; j < qtd; j++) {
					// se a distancia do vizinho é maior que...
					if (aberto.get(j) && (menorDistancia == -1 || distancia.get(j) < distancia.get(menorDistancia))) {
						menorDistancia = i;
					}

				}
				System.out.println(menorDistancia);
				aberto.set(menorDistancia, false);
				numAbertos++;
				for (Integer vizinho : grafo.retornarVizinhos(i)) {
					// ** Possivel erro na proxima linha
					if (vizinho != 0 && aberto.get(i) && distancia.get(i) != Double.MAX_VALUE) {
						double novaDistancia = distancia.get(menorDistancia) + vizinho;
						if (novaDistancia < distancia.get(i)) {
							distancia.set(i, novaDistancia);
						}
					}
				}
			}

		}

		for (int i = 1; i < qtd; i++) {
			System.out.println(i + " " + distancia.get(i));
		}

	}
}
