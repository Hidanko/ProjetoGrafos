package br.com.nemeth.algoritmos;

import java.util.List;
import java.util.Vector;

import br.com.nemeth.impl.GrafoMatriz;

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

	public static void execute(GrafoMatriz grafo, int inicial) {

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
		// enquanto exisitr algum vertice aberto
		int contador = 0;
		int i = inicial;
		do {
			double dist = Double.MAX_VALUE;
			int menorVizinho = 0;
			System.out.println(i + " - vizinhos " + grafo.retornarVizinhos(i).size());
			for (Integer vizinho : grafo.retornarVizinhos(i)) {
				double v = (double) grafo.getArestas().get(i).get(vizinho);
				anterior.set(vizinho, grafo.getVertices().get(i));
				distancia.set(vizinho, v);
				if (vizinho < dist + distancia.get(vizinho) && aberto.get(vizinho)) {
					dist = vizinho;
					menorVizinho = vizinho;
				}
			}
			aberto.set(i, false);
			i = menorVizinho;
			contador++;

			imprimir(qtd, aberto, anterior, distancia);
			System.out.println("\n");
		} while (contador < qtd);

		System.out.println("\n\nResultado:\n");
		for (int loop = 1; loop < qtd; loop++) {
			System.out.println(loop + " " + distancia.get(loop));
		}

	}

	private static void imprimir(int qtd, List<Boolean> aberto, List<String> anterior, List<Double> distancia) {
		System.out.println("*\t");
		for (Double d : distancia) {
			System.out.print(d + "\t");
		}
		System.out.println("\n");
		for (String s : anterior) {
			System.out.print(s + "\t");
		}

		System.out.println("\n");
		for (Boolean b : aberto) {
			System.out.print(b + "\t");
		}

		System.out.println("");
	}

}
